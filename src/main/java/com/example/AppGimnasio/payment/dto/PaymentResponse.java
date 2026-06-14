package com.example.AppGimnasio.payment.dto;

import com.example.AppGimnasio.payment.domain.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponse(
        UUID externalId,
        UUID enrollmentExternalId,
        BigDecimal amount,
        PaymentStatus status,
        LocalDateTime date
) {}
