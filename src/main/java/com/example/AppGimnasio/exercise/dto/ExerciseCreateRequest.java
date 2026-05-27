package com.example.AppGimnasio.exercise.dto;

import jakarta.validation.constraints.NotBlank;

public record ExerciseCreateRequest (
        @NotBlank String name,

        String description,

        String muscleGroup,

        String difficulty,

        String videoUrl
){}
