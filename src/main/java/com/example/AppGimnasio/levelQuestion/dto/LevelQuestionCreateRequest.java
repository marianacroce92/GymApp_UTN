package com.example.AppGimnasio.levelQuestion.dto;

import jakarta.validation.constraints.NotBlank;

public record LevelQuestionCreateRequest(
        @NotBlank String question
) {}
