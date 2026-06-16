package com.example.AppGimnasio.routineExercise.dto;

import java.util.UUID;

public record RoutineExerciseResponse(
        UUID externalId,
        UUID routineExternalId,
        String routineTitle,
        UUID exerciseExternalId,
        String exerciseName,
        Integer sets,
        Integer reps,
        Integer restSeconds,
        Integer displayOrder
) {}
