package com.example.AppGimnasio.payment.controller;

import com.example.AppGimnasio.payment.dto.PaymentCreateRequest;
import com.example.AppGimnasio.payment.dto.PaymentResponse;
import com.example.AppGimnasio.payment.service.IPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse create(
            @RequestBody @Valid PaymentCreateRequest request
    ) {
        return paymentService.create(request);
    }

    @GetMapping
    public List<PaymentResponse> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{externalId}")
    public PaymentResponse findByExternalId(
            @PathVariable UUID externalId
    ) {
        return paymentService.findByExternalId(externalId);
    }

    @GetMapping("/enrollment/{enrollmentExternalId}")
    public List<PaymentResponse> findByEnrollment(
            @PathVariable UUID enrollmentExternalId
    ) {
        return paymentService.findByEnrollment(enrollmentExternalId);
    }

    @PatchMapping("/{externalId}/pay")
    public PaymentResponse pay(
            @PathVariable UUID externalId
    ) {
        return paymentService.pay(externalId);
    }
}
