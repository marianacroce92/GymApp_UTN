package com.example.AppGimnasio.enrollment.controller;

import com.example.AppGimnasio.enrollment.dto.EnrollmentCreateRequest;
import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;
import com.example.AppGimnasio.enrollment.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService enrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResponse create(
            @RequestBody @Valid EnrollmentCreateRequest request
    ) {
        return enrollmentService.create(request);
    }

    @GetMapping
    public List<EnrollmentResponse> findAll() {
        return enrollmentService.findAll();
    }

    @GetMapping("/{externalId}")
    public EnrollmentResponse findByExternalId(
            @PathVariable UUID externalId
    ) {
        return enrollmentService.findByExternalId(externalId);
    }

    @GetMapping("/client/{clientUserExternalId}")
    public List<EnrollmentResponse> findByClient(
            @PathVariable UUID clientUserExternalId
    ) {
        return enrollmentService.findByClient(clientUserExternalId);
    }

    @PatchMapping("/{externalId}/cancel")
    public EnrollmentResponse cancel(
            @PathVariable UUID externalId
    ) {
        return enrollmentService.cancel(externalId);
    }
}
