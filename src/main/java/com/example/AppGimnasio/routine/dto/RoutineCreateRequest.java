package com.example.AppGimnasio.routine.dto;

import com.example.AppGimnasio.routine.domain.RoutineLevel;
import com.example.AppGimnasio.routine.domain.RoutineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record RoutineCreateRequest (

        @NotBlank String title,

        String description,

        @NotNull RoutineLevel level,

        @NotNull Long objectiveId,

        @NotNull RoutineType type,

        @NotNull BigDecimal price,

        @NotNull Integer durationDays,

        UUID trainerUserExternalId

){}