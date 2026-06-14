package com.example.AppGimnasio.progress.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record ProgressCreateRequest(
        @NotNull UUID clientUserExternalId,
        @NotNull Double weight,
        String note,
        LocalDate recordedAt
) {}
