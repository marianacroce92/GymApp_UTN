package com.example.AppGimnasio.objective.controller;

import com.example.AppGimnasio.objective.dto.ObjectiveCreateRequest;
import com.example.AppGimnasio.objective.dto.ObjectiveUpdateRequest;
import com.example.AppGimnasio.objective.dto.ObjectiveResponse;
import com.example.AppGimnasio.objective.service.ObjectiveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objectives")
@RequiredArgsConstructor
public class ObjectiveController {

    private ObjectiveService objectiveService;

    @PostMapping
    public ObjectiveResponse create(
            @Valid @RequestBody ObjectiveCreateRequest request) {

        return objectiveService.create(request);
    }

    @GetMapping
    public List<ObjectiveResponse> findAll() {
        return objectiveService.findAll();
    }

    @GetMapping("/{id}")
    public ObjectiveResponse findById(@PathVariable Long id) {
        return objectiveService.findById(id);
    }

    @PutMapping("/{id}")
    public ObjectiveResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ObjectiveUpdateRequest request) {

        return objectiveService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        objectiveService.delete(id);
    }
}
