package com.example.AppGimnasio.trainer.service;

import com.example.AppGimnasio.trainer.dto.TrainerCreateRequest;
import com.example.AppGimnasio.trainer.dto.TrainerResponse;
import com.example.AppGimnasio.trainer.dto.TrainerUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface ITrainerService {

    TrainerResponse create(
            TrainerCreateRequest request
    );

    List<TrainerResponse> findAll();

    TrainerResponse findByUserExternalId(
            UUID userExternalId
    );

    TrainerResponse update(
            UUID userExternalId,
            TrainerUpdateRequest request
    );

    void delete(
            UUID userExternalId
    );
}
