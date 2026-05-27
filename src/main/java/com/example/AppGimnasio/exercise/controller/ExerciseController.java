package com.example.AppGimnasio.exercise.controller;

import com.example.AppGimnasio.exercise.dto.ExerciseCreateRequest;
import com.example.AppGimnasio.exercise.dto.ExerciseResponse;
import com.example.AppGimnasio.exercise.dto.ExerciseUpdateRequest;
import com.example.AppGimnasio.exercise.service.ExerciseService;
import com.example.AppGimnasio.exercise.service.IExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final IExerciseService exerciseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseResponse create(
            @RequestBody @Valid ExerciseCreateRequest request
    ) {
        return exerciseService.create(request);
    }

    @GetMapping
    public List<ExerciseResponse> findAll() {
        return exerciseService.findAll();
    }

    @GetMapping("/{externalId}")
    public ExerciseResponse findByExternalId(
            @PathVariable UUID externalId
    ) {

        return  exerciseService.findByExternalId(
                externalId
        );
    }

    @PutMapping("/{externalId}")
    public ExerciseResponse update(
            @PathVariable UUID externalId,
            @RequestBody @Valid ExerciseUpdateRequest request
    ) {
        return exerciseService.update(externalId, request);
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID externalId
    ) {
        exerciseService.delete(externalId);
    }
}
