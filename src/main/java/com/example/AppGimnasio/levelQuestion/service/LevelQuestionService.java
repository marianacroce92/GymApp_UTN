package com.example.AppGimnasio.levelQuestion.service;

import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionCreateRequest;
import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionResponse;
import com.example.AppGimnasio.levelQuestion.mapper.LevelQuestionMapper;
import com.example.AppGimnasio.levelQuestion.repository.LevelQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelQuestionService {

    private final LevelQuestionRepository levelQuestionRepository;
    private final LevelQuestionMapper levelQuestionMapper;

    public LevelQuestionResponse create(LevelQuestionCreateRequest request) {

        LevelQuestionEntity entity = LevelQuestionEntity.builder()
                .question(request.question())
                .build();

        return levelQuestionMapper.toDto(
                levelQuestionRepository.save(entity)
        );
    }

    public List<LevelQuestionResponse> findAll() {
        return levelQuestionRepository.findAll()
                .stream()
                .map(levelQuestionMapper::toDto)
                .toList();
    }

    public LevelQuestionResponse findById(Integer id) {
        return levelQuestionRepository.findById(id)
                .map(levelQuestionMapper::toDto)
                .orElseThrow(() ->
                        new RuntimeException("Question not found"));
    }
}
