package com.example.AppGimnasio.payment.service;

import com.example.AppGimnasio.payment.dto.PaymentCreateRequest;
import com.example.AppGimnasio.payment.dto.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface IPaymentService {

    PaymentResponse create(PaymentCreateRequest request);

    PaymentResponse pay(UUID externalId);

    List<PaymentResponse> findAll();

    PaymentResponse findByExternalId(UUID externalId);

    List<PaymentResponse> findByEnrollment(UUID enrollmentExternalId);
}
