package com.example.AppGimnasio.routineObjective.dto;

import jakarta.validation.constraints.NotNull;

public record RoutineObjectiveUpdate(

        @NotNull Long routineId,

        @NotNull Long objectiveId

) {}