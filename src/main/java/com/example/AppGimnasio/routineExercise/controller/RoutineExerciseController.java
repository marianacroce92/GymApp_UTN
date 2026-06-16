package com.example.AppGimnasio.routineExercise.controller;

import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseCreateRequest;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseResponse;
import com.example.AppGimnasio.routineExercise.service.IRoutineExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routine-exercises")
@RequiredArgsConstructor
public class RoutineExerciseController {

    private final IRoutineExerciseService routineExerciseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineExerciseResponse create(
            @Valid @RequestBody RoutineExerciseCreateRequest request) {
        return routineExerciseService.create(request);
    }

    @GetMapping
    public List<RoutineExerciseResponse> findAll() {
        return routineExerciseService.findAll();
    }

    @GetMapping("/{externalId}")
    public RoutineExerciseResponse findByExternalId(
            @PathVariable UUID externalId) {
        return routineExerciseService.findByExternalId(externalId);
    }

    @GetMapping("/routine/{routineExternalId}")
    public List<RoutineExerciseResponse> findByRoutine(
            @PathVariable UUID routineExternalId) {
        return routineExerciseService.findByRoutine(routineExternalId);
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID externalId) {
        routineExerciseService.delete(externalId);
    }
}
