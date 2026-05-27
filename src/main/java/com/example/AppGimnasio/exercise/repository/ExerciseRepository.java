package com.example.AppGimnasio.exercise.repository;

import com.example.AppGimnasio.exercise.domain.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    Optional<ExerciseEntity> findByExternalId(
            UUID externalId
    );

    boolean existsByName(
            String name
    );
}
