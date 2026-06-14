package com.example.AppGimnasio.history.dto;

import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;
import com.example.AppGimnasio.payment.dto.PaymentResponse;
import com.example.AppGimnasio.progress.dto.ProgressResponse;

import java.util.List;
import java.util.UUID;

public record ClientHistoryResponse(
        UUID clientUserExternalId,
        String clientName,
        List<EnrollmentResponse> enrollments,
        List<PaymentResponse> payments,
        List<ProgressResponse> progressRecords
) {}
