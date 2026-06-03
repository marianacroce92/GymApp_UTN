package com.miGrupo.AppGimnasio.features.enrollment.entity;

import com.miGrupo.AppGimnasio.features.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;
    @ManyToOne
    @JoinColumn(name = "routine_id")
    private RoutineEntity routine;
    @Column(name = "status")
    private String status;
    @Column(name = "started_at")
    private LocalDateTime startedAt;
}
