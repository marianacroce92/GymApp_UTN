package com.example.AppGimnasio.levelAnswer.controller;

import com.example.AppGimnasio.levelAnswer.dto.LevelAnswerCreateRequest;
import com.example.AppGimnasio.levelAnswer.dto.LevelAnswerResponse;
import com.example.AppGimnasio.levelAnswer.service.LevelAnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/level-answers")
@RequiredArgsConstructor
public class LevelAnswerController {

    private final LevelAnswerService levelAnswerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LevelAnswerResponse create(
            @RequestBody @Valid LevelAnswerCreateRequest request) {
        return levelAnswerService.create(request);
    }
}
