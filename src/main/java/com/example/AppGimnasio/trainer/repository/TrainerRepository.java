package com.example.AppGimnasio.trainer.repository;

import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TrainerRepository extends JpaRepository<TrainerProfileEntity, Long> {

    Optional<TrainerProfileEntity> findByUserExternalId(
            UUID userExternalId
    );

    boolean existsByUserExternalId(
            UUID userExternalId
    );
}
