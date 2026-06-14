package com.example.AppGimnasio.payment.service;

import com.example.AppGimnasio.common.exception.EnrollmentNotFoundException;
import com.example.AppGimnasio.common.exception.PaymentNotFoundException;
import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import com.example.AppGimnasio.enrollment.repository.EnrollmentRepository;
import com.example.AppGimnasio.payment.domain.PaymentEntity;
import com.example.AppGimnasio.payment.domain.PaymentStatus;
import com.example.AppGimnasio.payment.dto.PaymentCreateRequest;
import com.example.AppGimnasio.payment.dto.PaymentResponse;
import com.example.AppGimnasio.payment.mapper.PaymentMapper;
import com.example.AppGimnasio.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse create(PaymentCreateRequest request) {

        EnrollmentEntity enrollment = enrollmentRepository
                .findByExternalId(request.enrollmentExternalId())
                .orElseThrow(() ->
                        new EnrollmentNotFoundException("Inscripción no encontrada."));

        PaymentEntity payment = PaymentEntity.builder()
                .enrollment(enrollment)
                .amount(enrollment.getRoutine().getPrice())
                .build();

        payment = paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    @Override
    public PaymentResponse pay(UUID externalId) {
        PaymentEntity payment = paymentRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new PaymentNotFoundException("Pago no encontrado."));
        payment.setStatus(PaymentStatus.PAID);
        payment = paymentRepository.save(payment);
        return paymentMapper.toResponse(payment);
    }

    @Override
    public List<PaymentResponse> findAll() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toResponse)
                .toList();
    }

    @Override
    public PaymentResponse findByExternalId(UUID externalId) {
        PaymentEntity payment = paymentRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new PaymentNotFoundException("Pago no encontrado."));
        return paymentMapper.toResponse(payment);
    }

    @Override
    public List<PaymentResponse> findByEnrollment(UUID enrollmentExternalId) {
        EnrollmentEntity enrollment = enrollmentRepository
                .findByExternalId(enrollmentExternalId)
                .orElseThrow(() ->
                        new EnrollmentNotFoundException("Inscripción no encontrada."));
        return paymentRepository.findByEnrollment(enrollment)
                .stream()
                .map(paymentMapper::toResponse)
                .toList();
    }
}
