package com.example.AppGimnasio.objective.service;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import com.example.AppGimnasio.objective.dto.ObjectiveCreateRequest;
import com.example.AppGimnasio.objective.dto.ObjectiveResponse;
import com.example.AppGimnasio.objective.dto.ObjectiveUpdateRequest;
import com.example.AppGimnasio.objective.mapper.ObjectiveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectiveService {

    private final ObjectiveService objectiveRepository;
    private final ObjectiveMapper objectiveMapper;
    private final ObjectiveEntity objetiveEntity;

    public ObjectiveService create(ObjectiveCreateRequest request) {

        if (objectiveRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Objective already exists");
        }

        ObjectiveEntity objective = objetiveEntity.builder()
                .name(request.getName())
                .build();

        return objectiveMapper.toResponse(
                objectiveRepository.save(objective)
        );
    }

    public List<ObjectiveResponse> findAll() {
        return objectiveRepository.findAll()
                .stream()
                .map(objectiveMapper::toResponse)
                .toList();
    }

    public ObjectiveResponse findById(Long id) {
        ObjectiveEntity objective = objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found"));

        return objectiveMapper.toResponse(objective);
    }

    public ObjectiveResponse update(Long id, ObjectiveUpdateRequest request) {

        ObjectiveEntity objective = objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found"));

        objective.setName(request.getName());

        return objectiveMapper.toResponse(
                objectiveRepository.save(objective)
        );
    }

    public void delete(Long id) {

        ObjectiveEntity objective = objectiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objective not found"));

        objectiveRepository.delete(objective);
    }
}