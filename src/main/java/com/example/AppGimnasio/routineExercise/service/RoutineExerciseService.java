package com.example.AppGimnasio.routineExercise.service;

import com.example.AppGimnasio.common.exception.ExerciseNotFoundException;
import com.example.AppGimnasio.common.exception.RoutineExerciseNotFoundException;
import com.example.AppGimnasio.common.exception.RoutineNotFoundException;
import com.example.AppGimnasio.exercise.domain.ExerciseEntity;
import com.example.AppGimnasio.exercise.repository.ExerciseRepository;
import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routine.repository.RoutineRepository;
import com.example.AppGimnasio.routineExercise.domain.RoutineExerciseEntity;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseCreateRequest;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseResponse;
import com.example.AppGimnasio.routineExercise.mapper.RoutineExerciseMapper;
import com.example.AppGimnasio.routineExercise.repository.RoutineExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoutineExerciseService implements IRoutineExerciseService {

    private final RoutineExerciseRepository routineExerciseRepository;
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;
    private final RoutineExerciseMapper routineExerciseMapper;

    @Override
    @Transactional
    public RoutineExerciseResponse create(RoutineExerciseCreateRequest request) {

        RoutineEntity routine = routineRepository
                .findByExternalId(request.routineExternalId())
                .orElseThrow(() -> new RoutineNotFoundException("Rutina no encontrada."));

        ExerciseEntity exercise = exerciseRepository
                .findByExternalId(request.exerciseExternalId())
                .orElseThrow(() -> new ExerciseNotFoundException("Ejercicio no encontrado."));

        RoutineExerciseEntity entity = routineExerciseMapper.toEntity(request);
        entity.setRoutine(routine);
        entity.setExercise(exercise);

        return routineExerciseMapper.toResponse(
                routineExerciseRepository.save(entity)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoutineExerciseResponse> findAll() {
        return routineExerciseRepository.findAll()
                .stream()
                .map(routineExerciseMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RoutineExerciseResponse findByExternalId(UUID externalId) {
        RoutineExerciseEntity entity = routineExerciseRepository
                .findByExternalId(externalId)
                .orElseThrow(() -> new RoutineExerciseNotFoundException(
                        "Asociación rutina-ejercicio no encontrada."));
        return routineExerciseMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoutineExerciseResponse> findByRoutine(UUID routineExternalId) {
        RoutineEntity routine = routineRepository
                .findByExternalId(routineExternalId)
                .orElseThrow(() -> new RoutineNotFoundException("Rutina no encontrada."));
        return routineExerciseRepository.findByRoutine(routine)
                .stream()
                .map(routineExerciseMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void delete(UUID externalId) {
        RoutineExerciseEntity entity = routineExerciseRepository
                .findByExternalId(externalId)
                .orElseThrow(() -> new RoutineExerciseNotFoundException(
                        "Asociación rutina-ejercicio no encontrada."));
        routineExerciseRepository.delete(entity);
    }
}
