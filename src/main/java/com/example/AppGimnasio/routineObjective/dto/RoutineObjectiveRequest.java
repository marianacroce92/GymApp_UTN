package com.example.AppGimnasio.routineObjective.dto;

import jakarta.validation.constraints.NotNull;

public record RoutineObjectiveRequest(

        @NotNull Long routineId,

        @NotNull Long objectiveId

) {}