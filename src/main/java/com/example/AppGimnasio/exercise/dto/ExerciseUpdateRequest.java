package com.example.AppGimnasio.exercise.dto;

public record ExerciseUpdateRequest (

        String name,

        String description,

        String muscleGroup,

        String difficulty,

        String videoUrl
) {}
