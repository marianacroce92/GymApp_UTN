package com.example.AppGimnasio.userLevelTest.dto;

import com.example.AppGimnasio.routine.dto.RoutineResponse;
import com.example.AppGimnasio.userLevelTest.domain.ResultLevel;

import java.util.List;

public record TestResultResponse(
        Integer id,
        Integer score,
        Integer maxScore,
        ResultLevel resultLevel,
        List<RoutineResponse> recommendedRoutines
) {}
