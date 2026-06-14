package com.example.AppGimnasio.routineObjective.repository;

import com.example.AppGimnasio.routineObjective.domain.RoutineObjectiveEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineObjectiveRepository extends JpaRepository<RoutineObjectiveEntity,Integer> {
    boolean existsByRoutineIdAndObjectiveId(@NotNull Integer integer);
}
