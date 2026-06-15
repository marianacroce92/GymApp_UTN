package com.example.AppGimnasio.levelAnswer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LevelAnswerCreateRequest(
        @NotBlank String answer,
        @NotNull Integer score,
        @NotNull Integer questionId
) {}
