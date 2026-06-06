package com.example.AppGimnasio.levelQuestion.service;

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