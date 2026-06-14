package com.example.AppGimnasio.payment.repository;

import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import com.example.AppGimnasio.payment.domain.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    Optional<PaymentEntity> findByExternalId(UUID externalId);

    List<PaymentEntity> findByEnrollment(EnrollmentEntity enrollment);
}
