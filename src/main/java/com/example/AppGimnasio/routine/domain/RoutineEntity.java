package com.example.AppGimnasio.routine.domain;

import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "routines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RoutineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private RoutineLevel level;

    @Enumerated(EnumType.STRING)
    @Column(name = "objective", nullable = false)
    private RoutineObjective objective;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RoutineType type;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerProfileEntity trainer;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {

        if (externalId == null)
            externalId = UUID.randomUUID();

        if (createdAt == null)
            createdAt = LocalDateTime.now();
    }
}
