package com.example.AppGimnasio.routine.service;

import com.example.AppGimnasio.routine.dto.RoutineCreateRequest;
import com.example.AppGimnasio.routine.dto.RoutineResponse;
import com.example.AppGimnasio.routine.dto.RoutineUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IRoutineService {

    RoutineResponse create(RoutineCreateRequest request);

    List<RoutineResponse> findAll();

    RoutineResponse findByExternalId(UUID externalId);

    List<RoutineResponse> findByTrainer(UUID trainerUserExternalId);

    RoutineResponse update(UUID externalId, RoutineUpdateRequest request);

    void delete(UUID externalId);
}
