package com.example.AppGimnasio.routineObjective.dto;

import jakarta.validation.constraints.NotNull;

public record RoutineObjectiveRequest(

       // @NotNull Integer routineId;

        @NotNull Integer objectiveId,

) {}