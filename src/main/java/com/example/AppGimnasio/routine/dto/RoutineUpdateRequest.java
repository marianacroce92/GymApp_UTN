package com.example.AppGimnasio.routine.dto;

import com.example.AppGimnasio.routine.domain.RoutineLevel;
import com.example.AppGimnasio.routine.domain.RoutineObjective;
import com.example.AppGimnasio.routine.domain.RoutineType;

import java.math.BigDecimal;


public record RoutineUpdateRequest (

        String title,

        String description,

        RoutineLevel level,

        RoutineObjective objective,

        RoutineType type,

        BigDecimal price,

        Integer durationDays

){}
