package com.example.AppGimnasio.client;

import com.example.AppGimnasio.user.domain.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientProfileEntity {
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "weigth")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @Column(name = "age")
    private Integer age; // MODIFICAR SEGUN FECHA DE NACIMIENTO

    @Column(name = "experience_level")
    private String experiencieLevel;
}
