package com.example.AppGimnasio.progress.domain;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "progress_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientProfileEntity client;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "note")
    private String note;

    @Column(name = "recorded_at", nullable = false)
    private LocalDate recordedAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        if (externalId == null)
            externalId = UUID.randomUUID();

        if (createdAt == null)
            createdAt = LocalDateTime.now();

        if (recordedAt == null)
            recordedAt = LocalDate.now();
    }
}
