package com.example.AppGimnasio.progress.controller;

import com.example.AppGimnasio.progress.dto.ProgressCreateRequest;
import com.example.AppGimnasio.progress.dto.ProgressResponse;
import com.example.AppGimnasio.progress.service.IProgressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final IProgressService progressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProgressResponse create(
            @RequestBody @Valid ProgressCreateRequest request
    ) {
        return progressService.create(request);
    }

    @GetMapping
    public List<ProgressResponse> findAll() {
        return progressService.findAll();
    }

    @GetMapping("/{externalId}")
    public ProgressResponse findByExternalId(
            @PathVariable UUID externalId
    ) {
        return progressService.findByExternalId(externalId);
    }

    @GetMapping("/client/{clientUserExternalId}")
    public List<ProgressResponse> findByClient(
            @PathVariable UUID clientUserExternalId
    ) {
        return progressService.findByClient(clientUserExternalId);
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID externalId
    ) {
        progressService.delete(externalId);
    }
}
