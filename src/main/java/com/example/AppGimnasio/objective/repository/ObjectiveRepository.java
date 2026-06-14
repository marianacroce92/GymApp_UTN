package com.example.AppGimnasio.objective.repository;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObjectiveRepository extends JpaRepository<ObjectiveEntity, Long> {

    Optional<ObjectiveEntity> findByName(String name);

    boolean existsByName(String name);
}