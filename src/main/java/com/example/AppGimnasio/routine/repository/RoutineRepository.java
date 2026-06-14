package com.example.AppGimnasio.routine.repository;

import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository extends JpaRepository<RoutineEntity, Long> {

    Optional<RoutineEntity> findByExternalId(
            UUID externalId
    );

    List<RoutineEntity> findByTrainer(
            TrainerProfileEntity trainer
    );

    boolean existsByTitle(
            String title
    );
}
