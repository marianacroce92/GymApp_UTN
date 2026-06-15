package com.example.AppGimnasio.userLevelTest.service;

import com.example.AppGimnasio.levelAnswer.domain.LevelAnswerEntity;
import com.example.AppGimnasio.levelAnswer.repository.LevelAnswerRepository;
import com.example.AppGimnasio.routine.domain.RoutineLevel;
import com.example.AppGimnasio.routine.dto.RoutineResponse;
import com.example.AppGimnasio.routine.mapper.RoutineMapper;
import com.example.AppGimnasio.routine.repository.RoutineRepository;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.repository.UserRepository;
import com.example.AppGimnasio.userLevelTest.domain.ResultLevel;
import com.example.AppGimnasio.userLevelTest.domain.UserLevelTestEntity;
import com.example.AppGimnasio.userLevelTest.dto.SubmitTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.TestResultResponse;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestResponse;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestUpdate;
import com.example.AppGimnasio.userLevelTest.mapper.UserLevelTestMapper;
import com.example.AppGimnasio.userLevelTest.repository.UserLevelTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLevelTestService {

    private final UserLevelTestRepository userLevelTestRepository;
    private final UserRepository userRepository;
    private final UserLevelTestMapper userLevelTestMapper;
    private final LevelAnswerRepository levelAnswerRepository;
    private final RoutineRepository routineRepository;
    private final RoutineMapper routineMapper;

    public UserLevelTestResponse create(UserLevelTestRequest request) {

        UserEntity user = userRepository.findById(
                        Long.valueOf(request.userId()))
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserLevelTestEntity entity = UserLevelTestEntity.builder()
                .user(user)
                .createdAt(LocalDate.now())
                .build();

        return userLevelTestMapper.toDto(
                userLevelTestRepository.save(entity)
        );
    }

    public List<UserLevelTestResponse> findAll() {
        return userLevelTestRepository.findAll()
                .stream()
                .map(userLevelTestMapper::toDto)
                .toList();
    }

    public UserLevelTestResponse findById(Integer id) {

        UserLevelTestEntity entity = userLevelTestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Level test not found"));

        return userLevelTestMapper.toDto(entity);
    }

    public UserLevelTestResponse update(Integer id, UserLevelTestUpdate request) {

        UserLevelTestEntity entity = userLevelTestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Level test not found"));

        entity.setScore(request.score());
        entity.setResultLevel(request.resultLevel());

        return userLevelTestMapper.toDto(
                userLevelTestRepository.save(entity)
        );
    }

    public void delete(Integer id) {

        UserLevelTestEntity entity = userLevelTestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Level test not found"));

        userLevelTestRepository.delete(entity);
    }

    @Transactional
    public TestResultResponse submitTest(SubmitTestRequest request) {

        UserEntity user = userRepository
                .findByExternalId(request.userExternalId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        List<LevelAnswerEntity> answers =
                levelAnswerRepository.findAllById(request.answerIds());

        if (answers.size() != request.answerIds().size()) {
            throw new RuntimeException("Una o más respuestas no existen.");
        }

        int score = answers.stream()
                .mapToInt(LevelAnswerEntity::getScore)
                .sum();

        int maxScore = answers.stream()
                .map(LevelAnswerEntity::getLevelQuestion)
                .distinct()
                .mapToInt(question ->
                        question.getAnswers().stream()
                                .mapToInt(LevelAnswerEntity::getScore)
                                .max()
                                .orElse(0))
                .sum();

        double percentage = maxScore > 0 ? (double) score / maxScore * 100 : 0;

        ResultLevel resultLevel;
        if (percentage <= 40) {
            resultLevel = ResultLevel.PRINCIPIANTE;
        } else if (percentage <= 75) {
            resultLevel = ResultLevel.INTERMEDIO;
        } else {
            resultLevel = ResultLevel.AVANZADO;
        }

        UserLevelTestEntity entity = UserLevelTestEntity.builder()
                .user(user)
                .score(score)
                .resultLevel(resultLevel)
                .createdAt(LocalDate.now())
                .build();

        entity = userLevelTestRepository.save(entity);

        RoutineLevel routineLevel = toRoutineLevel(resultLevel);

        List<RoutineResponse> recommendedRoutines = routineRepository
                .findByLevel(routineLevel)
                .stream()
                .map(routineMapper::toResponse)
                .toList();

        return new TestResultResponse(
                entity.getId(),
                score,
                maxScore,
                resultLevel,
                recommendedRoutines
        );
    }

    private RoutineLevel toRoutineLevel(ResultLevel resultLevel) {
        return switch (resultLevel) {
            case PRINCIPIANTE -> RoutineLevel.BEGINNER;
            case INTERMEDIO   -> RoutineLevel.INTERMEDIATE;
            case AVANZADO     -> RoutineLevel.ADVANCED;
        };
    }
}
