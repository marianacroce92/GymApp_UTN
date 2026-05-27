package com.example.AppGimnasio.exercise.service;

import com.example.AppGimnasio.common.exception.ExerciseAlreadyExistsException;
import com.example.AppGimnasio.common.exception.ExerciseNotFoundException;
import com.example.AppGimnasio.exercise.domain.ExerciseEntity;
import com.example.AppGimnasio.exercise.dto.ExerciseCreateRequest;
import com.example.AppGimnasio.exercise.dto.ExerciseResponse;
import com.example.AppGimnasio.exercise.dto.ExerciseUpdateRequest;
import com.example.AppGimnasio.exercise.mapper.ExerciseMapper;
import com.example.AppGimnasio.exercise.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseService implements IExerciseService{

    private final ExerciseRepository exerciseRepository;

    private final ExerciseMapper exerciseMapper;

    @Override
    public ExerciseResponse create(
            ExerciseCreateRequest request
    ) {

        if(exerciseRepository.existsByName(
                request.name()
        )) {
            throw new ExerciseAlreadyExistsException(
                    "El ejercicio ya existe."
            );
        }

        ExerciseEntity exercise =
                exerciseMapper.toEntity(request);

        exercise = exerciseRepository.save(exercise);

        return exerciseMapper.toResponse(exercise);
    }

    @Override
    public List<ExerciseResponse> findAll() {

        return  exerciseRepository.findAll()
                .stream()
                .map(exerciseMapper::toResponse)
                .toList();
    }

    @Override
    public ExerciseResponse findByExternalId(
            UUID externalId
    ) {

        ExerciseEntity exercise =
                exerciseRepository.findByExternalId(
                        externalId
                )
                        .orElseThrow(() ->
                                new ExerciseNotFoundException(
                                        "Ejercicio no encontrado."
                                ));

        return exerciseMapper.toResponse(exercise);
    }

    @Override
    public ExerciseResponse update(
            UUID externalId,
            ExerciseUpdateRequest request
    ) {

        ExerciseEntity exercise =
                exerciseRepository.findByExternalId(
                        externalId
                )
                        .orElseThrow(() ->
                                new ExerciseNotFoundException(
                                        "Ejercicio no encontrado."
                                ));

        exercise.setName(request.name());
        exercise.setDescription(request.description());
        exercise.setMuscleGroup(request.muscleGroup());
        exercise.setDifficulty(request.difficulty());
        exercise.setVideoUrl(request.videoUrl());

        exercise = exerciseRepository.save(exercise);

        return  exerciseMapper.toResponse(exercise);
    }

    @Override
    public void delete(
            UUID externalId
    ) {

        ExerciseEntity exercise =
                exerciseRepository.findByExternalId(
                        externalId
                )
                        .orElseThrow(() ->
                                new ExerciseNotFoundException(
                                        "Ejercicio no encontrado."
                                ));

        exerciseRepository.delete(exercise);
    }
}
