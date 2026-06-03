package com.miGrupo.AppGimnasio.features.clientProfile.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "weight")
    private Double weight;
    @Column(name = "height")
    private Double height;
    @Column(name = "age")
    private Integer age;
}
