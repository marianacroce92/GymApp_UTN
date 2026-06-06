package com.example.AppGimnasio.userLevelTest.service;

import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.repository.UserRepository;
import com.example.AppGimnasio.userLevelTest.domain.UserLevelTestEntity;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestResponse;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestUpdate;
import com.example.AppGimnasio.userLevelTest.mapper.UserLevelTestMapper;
import com.example.AppGimnasio.userLevelTest.repository.UserLevelTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLevelTestService {

    private final UserLevelTestRepository userLevelTestRepository;
    private final UserRepository userRepository;
    private final UserLevelTestMapper userLevelTestMapper;

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

    public UserLevelTestResponse update(
            Integer id,
            UserLevelTestUpdate request) {

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
}