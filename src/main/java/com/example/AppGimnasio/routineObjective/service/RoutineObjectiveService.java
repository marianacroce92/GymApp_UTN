package com.example.AppGimnasio.routineObjective.service;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import com.example.AppGimnasio.objective.repository.ObjectiveRepository;
import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routine.repository.RoutineRepository;
import com.example.AppGimnasio.routineObjective.domain.RoutineObjectiveEntity;
import com.example.AppGimnasio.routineObjective.dto.RoutineObjectiveRequest;
import com.example.AppGimnasio.routineObjective.dto.RoutineObjectiveResponse;
import com.example.AppGimnasio.routineObjective.dto.RoutineObjectiveUpdate;
import com.example.AppGimnasio.routineObjective.mapper.RoutineObjectiveMapper;
import com.example.AppGimnasio.routineObjective.repository.RoutineObjectiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineObjectiveService {

    private final RoutineObjectiveRepository routineObjectiveRepository;
    private final ObjectiveRepository objectiveRepository;
    private final RoutineRepository routineRepository;
    private final RoutineObjectiveMapper routineObjectiveMapper;

    public RoutineObjectiveResponse create(RoutineObjectiveRequest request) {

        if (routineObjectiveRepository.existsByRoutineIdAndObjectiveId(
                request.routineId(), request.objectiveId())) {
            throw new IllegalArgumentException("The relationship already exists");
        }

        RoutineEntity routine = routineRepository.findById(request.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        ObjectiveEntity objective = objectiveRepository.findById(request.objectiveId())
                .orElseThrow(() -> new RuntimeException("Objective not found"));

        RoutineObjectiveEntity entity = RoutineObjectiveEntity.builder()
                .routine(routine)
                .objective(objective)
                .build();

        return routineObjectiveMapper.toResponse(
                routineObjectiveRepository.save(entity)
        );
    }

    public List<RoutineObjectiveResponse> findAll() {
        return routineObjectiveRepository.findAll()
                .stream()
                .map(routineObjectiveMapper::toResponse)
                .toList();
    }

    public RoutineObjectiveResponse findById(Integer id) {
        RoutineObjectiveEntity entity = routineObjectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relation not found"));
        return routineObjectiveMapper.toResponse(entity);
    }

    public RoutineObjectiveResponse update(Integer id, RoutineObjectiveUpdate request) {

        RoutineObjectiveEntity entity = routineObjectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relation not found"));

        RoutineEntity routine = routineRepository.findById(request.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        ObjectiveEntity objective = objectiveRepository.findById(request.objectiveId())
                .orElseThrow(() -> new RuntimeException("Objective not found"));

        entity.setRoutine(routine);
        entity.setObjective(objective);

        return routineObjectiveMapper.toResponse(
                routineObjectiveRepository.save(entity)
        );
    }

    public void delete(Integer id) {
        RoutineObjectiveEntity entity = routineObjectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relation not found"));
        routineObjectiveRepository.delete(entity);
    }
}