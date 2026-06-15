package com.example.AppGimnasio.levelAnswer.service;

import com.example.AppGimnasio.levelAnswer.domain.LevelAnswerEntity;
import com.example.AppGimnasio.levelAnswer.dto.LevelAnswerCreateRequest;
import com.example.AppGimnasio.levelAnswer.dto.LevelAnswerResponse;
import com.example.AppGimnasio.levelAnswer.repository.LevelAnswerRepository;
import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import com.example.AppGimnasio.levelQuestion.repository.LevelQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelAnswerService {

    private final LevelAnswerRepository levelAnswerRepository;
    private final LevelQuestionRepository levelQuestionRepository;

    public LevelAnswerResponse create(LevelAnswerCreateRequest request) {

        LevelQuestionEntity question = levelQuestionRepository
                .findById(request.questionId())
                .orElseThrow(() ->
                        new RuntimeException("Pregunta no encontrada."));

        LevelAnswerEntity entity = LevelAnswerEntity.builder()
                .answer(request.answer())
                .score(request.score())
                .levelQuestion(question)
                .build();

        return toResponse(levelAnswerRepository.save(entity));
    }

    private LevelAnswerResponse toResponse(LevelAnswerEntity entity) {
        return new LevelAnswerResponse(
                entity.getId(),
                entity.getAnswer(),
                entity.getScore(),
                entity.getLevelQuestion().getId()
        );
    }
}
