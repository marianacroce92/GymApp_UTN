package com.example.AppGimnasio.routineExercise.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RoutineExerciseCreateRequest(
        @NotNull UUID routineExternalId,
        @NotNull UUID exerciseExternalId,
        Integer sets,
        Integer reps,
        Integer restSeconds,
        Integer displayOrder
) {}
