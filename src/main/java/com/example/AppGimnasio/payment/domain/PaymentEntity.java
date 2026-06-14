package com.example.AppGimnasio.payment.domain;

import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id", nullable = false)
    private EnrollmentEntity enrollment;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @Column(name = "date", nullable = false, updatable = false)
    private LocalDateTime date;

    @PrePersist
    void onCreate() {
        if (externalId == null)
            externalId = UUID.randomUUID();

        if (date == null)
            date = LocalDateTime.now();

        if (status == null)
            status = PaymentStatus.PENDING;
    }
}
