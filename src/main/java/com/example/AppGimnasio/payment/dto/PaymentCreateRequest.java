package com.example.AppGimnasio.payment.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentCreateRequest(
        @NotNull UUID enrollmentExternalId
) {}
