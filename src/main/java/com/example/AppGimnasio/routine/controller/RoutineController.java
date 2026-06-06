package com.example.AppGimnasio.routine.controller;

import com.example.AppGimnasio.routine.dto.RoutineCreateRequest;
import com.example.AppGimnasio.routine.dto.RoutineResponse;
import com.example.AppGimnasio.routine.dto.RoutineUpdateRequest;
import com.example.AppGimnasio.routine.service.IRoutineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routines")
@RequiredArgsConstructor

public class RoutineController {

    private final IRoutineService routineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoutineResponse create(
            @RequestBody @Valid RoutineCreateRequest request
    ) {
        return routineService.create(request);
    }

    @GetMapping
    public List<RoutineResponse> findAll() {
        return routineService.findAll();
    }

    @GetMapping("/{externalId}")
    public RoutineResponse findByExternalId(
            @PathVariable UUID externalId
    ) {
        return routineService.findByExternalId(externalId);
    }

    @GetMapping("/trainer/{trainerUserExternalId}")
    public List<RoutineResponse> findByTrainer(
            @PathVariable UUID trainerUserExternalId
    ) {
      return  routineService.findByTrainer(trainerUserExternalId);
    }

    @PutMapping("/{externalId}")
    public RoutineResponse update(
            @PathVariable UUID externalId,
            @RequestBody @Valid RoutineUpdateRequest request
    ) {
        return routineService.update(externalId, request);
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID externalId
    ) {
        routineService.delete(externalId);
    }
}
