package com.example.AppGimnasio.exercise.service;

import com.example.AppGimnasio.exercise.dto.ExerciseCreateRequest;
import com.example.AppGimnasio.exercise.dto.ExerciseResponse;
import com.example.AppGimnasio.exercise.dto.ExerciseUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IExerciseService {

    ExerciseResponse create(ExerciseCreateRequest request);

    List<ExerciseResponse> findAll();

    ExerciseResponse findByExternalId(UUID externalId);

    ExerciseResponse update(UUID externalId, ExerciseUpdateRequest request);

    void delete(UUID externalId);
}
