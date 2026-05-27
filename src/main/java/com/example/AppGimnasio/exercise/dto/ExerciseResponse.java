package com.example.AppGimnasio.exercise.dto;

import java.util.UUID;

public record ExerciseResponse(

        UUID externalId,

        String name,

        String description,

        String muscleGroup,

        String difficulty,

        String videoUrl

) {
}