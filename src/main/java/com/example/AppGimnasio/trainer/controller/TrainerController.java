package com.example.AppGimnasio.trainer.controller;

import com.example.AppGimnasio.trainer.dto.TrainerCreateRequest;
import com.example.AppGimnasio.trainer.dto.TrainerResponse;
import com.example.AppGimnasio.trainer.dto.TrainerUpdateRequest;
import com.example.AppGimnasio.trainer.service.ITrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final ITrainerService trainerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponse create(
            @RequestBody @Valid TrainerCreateRequest request
    ) {

        return  trainerService.create(request);
    }

    @GetMapping
    public List<TrainerResponse> findAll() {

        return trainerService.findAll();
    }

    @GetMapping("/{userExternalId}")
    public TrainerResponse findByUserExternalId(
            @PathVariable UUID userExternalId
    ) {

        return trainerService.findByUserExternalId(
                userExternalId
        );
    }

    @PutMapping("/{userExternalId}")
    public TrainerResponse update(
            @PathVariable UUID userExternalId,
            @RequestBody @Valid TrainerUpdateRequest request
    ) {

        return trainerService.update(
                userExternalId,
                request
        );
    }

    @DeleteMapping("/{userExternalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID userExternalId
    ) {

        trainerService.delete(userExternalId);
    }
}
