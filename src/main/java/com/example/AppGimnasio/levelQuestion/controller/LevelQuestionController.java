package com.example.AppGimnasio.levelQuestion.controller;

import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionCreateRequest;
import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionResponse;
import com.example.AppGimnasio.levelQuestion.service.LevelQuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/level-questions")
@RequiredArgsConstructor
public class LevelQuestionController {

    private final LevelQuestionService levelQuestionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LevelQuestionResponse create(
            @RequestBody @Valid LevelQuestionCreateRequest request) {
        return levelQuestionService.create(request);
    }

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