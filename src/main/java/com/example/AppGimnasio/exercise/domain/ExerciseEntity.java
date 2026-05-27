package com.example.AppGimnasio.exercise.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "muscle_group")
    private String muscleGroup;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "video_url")
    private String videoUrl;

    @PrePersist
    void onCreate() {
        if (externalId == null)
            externalId = UUID.randomUUID();
    }
}
