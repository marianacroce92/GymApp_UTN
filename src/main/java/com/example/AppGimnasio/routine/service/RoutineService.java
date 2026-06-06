package com.example.AppGimnasio.routine.service;

import com.example.AppGimnasio.common.exception.RoutineAlreadyExistsException;
import com.example.AppGimnasio.common.exception.RoutineNotFoundException;
import com.example.AppGimnasio.common.exception.TrainerNotFoundException;
import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routine.dto.RoutineCreateRequest;
import com.example.AppGimnasio.routine.dto.RoutineResponse;
import com.example.AppGimnasio.routine.dto.RoutineUpdateRequest;
import com.example.AppGimnasio.routine.mapper.RoutineMapper;
import com.example.AppGimnasio.routine.repository.RoutineRepository;
import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import com.example.AppGimnasio.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class RoutineService implements IRoutineService {

    private final RoutineRepository routineRepository;
    private final TrainerRepository trainerRepository;
    private final RoutineMapper routineMapper;

    @Override
    public RoutineResponse create(RoutineCreateRequest request)  {

        if(routineRepository.existsByTitle(request.title())) {
            throw new RoutineAlreadyExistsException("Ya existe una rutina con ese nombre.");
        }

        TrainerProfileEntity trainer = null;

        if(request.trainerUserExternalId() != null) {

            trainer = trainerRepository
                    .findByUserExternalId(request.trainerUserExternalId())
                    .orElseThrow(() ->
                            new TrainerNotFoundException("Perfil de entrenador no encontrado."));
        }

        RoutineEntity routine = routineMapper.toEntity(request);

        routine.setTrainer(trainer);

        routine = routineRepository.save(routine);

        return routineMapper.toResponse(routine);
    }

    @Override
    public List<RoutineResponse> findAll() {

        return  routineRepository.findAll()
                .stream()
                .map(routineMapper::toResponse)
                .toList();
    }

    @Override
    public RoutineResponse findByExternalId(UUID externalId) {

        RoutineEntity routine = routineRepository.findByExternalId(externalId)
                .orElseThrow(() ->
                        new RoutineNotFoundException("Rutina no encontrada."));

        return routineMapper.toResponse(routine);
    }

    @Override
    public List<RoutineResponse> findByTrainer(UUID trainerUserExternalId) {

        TrainerProfileEntity trainer = trainerRepository
                .findByUserExternalId(trainerUserExternalId)
                .orElseThrow(() ->
                        new TrainerNotFoundException("Perfil de entrenador no encontrado."));

        return  routineRepository.findByTrainer(trainer)
                .stream()
                .map(routineMapper::toResponse)
                .toList();
    }

    @Override
    public RoutineResponse update(UUID externalId, RoutineUpdateRequest request) {

        RoutineEntity routine = routineRepository.findByExternalId(externalId)
                .orElseThrow(() ->
                        new RoutineNotFoundException("Rutina no encontrada."));

        routine.setTitle(request.title());
        routine.setDescription(request.description());
        routine.setLevel(request.level());
        routine.setObjective(request.objective());
        routine.setType(request.type());
        routine.setPrice(request.price());
        routine.setDurationDays(request.durationDays());

        routine = routineRepository.save(routine);

        return routineMapper.toResponse(routine);
    }

    @Override
    public void delete(UUID externalId) {

        RoutineEntity routine = routineRepository.findByExternalId(externalId)
                .orElseThrow(() ->
                        new RoutineNotFoundException("Rutina no encontrada."));

        routineRepository.delete(routine);
    }
}
