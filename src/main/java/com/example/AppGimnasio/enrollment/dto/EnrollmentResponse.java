package com.example.AppGimnasio.enrollment.dto;

import com.example.AppGimnasio.enrollment.domain.EnrollmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record EnrollmentResponse(
        UUID externalId,
        UUID clientUserExternalId,
        String clientName,
        UUID routineExternalId,
        String routineTitle,
        EnrollmentStatus status,
        LocalDateTime createdAt
) {}
