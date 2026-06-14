package com.example.AppGimnasio.enrollment.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EnrollmentCreateRequest(
        @NotNull UUID clientUserExternalId,
        @NotNull UUID routineExternalId
) {}
