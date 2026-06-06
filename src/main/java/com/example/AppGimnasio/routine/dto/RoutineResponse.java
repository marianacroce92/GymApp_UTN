package com.example.AppGimnasio.routine.dto;

import com.example.AppGimnasio.routine.domain.RoutineLevel;
import com.example.AppGimnasio.routine.domain.RoutineObjective;
import com.example.AppGimnasio.routine.domain.RoutineType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RoutineResponse (

        UUID externalId,

        String title,

        String description,

        RoutineLevel level,

        RoutineObjective objective,

        RoutineType type,

        BigDecimal price,

        Integer durationDays,

        UUID trainerUserExternalId,

        String trainerUsername,

        LocalDateTime createdAt
){}
