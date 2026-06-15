package com.example.AppGimnasio.levelAnswer.dto;

public record LevelAnswerResponse(
        Integer id,
        String answer,
        Integer score,
        Integer questionId
) {}
