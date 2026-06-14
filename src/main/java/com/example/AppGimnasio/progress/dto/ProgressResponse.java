package com.example.AppGimnasio.progress.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProgressResponse(
        UUID externalId,
        UUID clientUserExternalId,
        String clientName,
        Double weight,
        String note,
        LocalDate recordedAt,
        LocalDateTime createdAt
) {}
