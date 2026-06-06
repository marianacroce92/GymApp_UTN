package com.example.AppGimnasio.levelQuestion.controller;

import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionResponse;
import com.example.AppGimnasio.levelQuestion.service.LevelQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/level-questions")
@RequiredArgsConstructor
public class LevelQuestionController {

    private final LevelQuestionService levelQuestionService;

    @GetMapping
    public List<LevelQuestionResponse> findAll() {
        return levelQuestionService.findAll();
    }

    @GetMapping("/{id}")
    public LevelQuestionResponse findById(
            @PathVariable Integer id) {

        return levelQuestionService.findById(id);
    }
}