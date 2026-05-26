package com.example.AppGimnasio.trainer;

import com.example.AppGimnasio.user.domain.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trainer_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TrainerProfileEntity {
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "bio", nullable = false)
    private String bio; // SEGURAMENTE SE AGREGUE OTRA CLASE

    @Column(name = "verified")
    private Boolean verified;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "whatsapp")
    private String whatsapp;

    @PrePersist
    void onCreate() {

        if (verified == null)
            verified = false;
    }
}
