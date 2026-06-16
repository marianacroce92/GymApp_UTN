package com.example.AppGimnasio.routineExercise.service;

import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseCreateRequest;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseResponse;

import java.util.List;
import java.util.UUID;

public interface IRoutineExerciseService {

    RoutineExerciseResponse create(RoutineExerciseCreateRequest request);

    List<RoutineExerciseResponse> findAll();

    RoutineExerciseResponse findByExternalId(UUID externalId);

    List<RoutineExerciseResponse> findByRoutine(UUID routineExternalId);

    void delete(UUID externalId);
}
