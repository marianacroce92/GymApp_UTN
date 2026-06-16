package com.example.AppGimnasio.routineExercise.repository;

import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routineExercise.domain.RoutineExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExerciseEntity, Long> {

    Optional<RoutineExerciseEntity> findByExternalId(UUID externalId);

    List<RoutineExerciseEntity> findByRoutine(RoutineEntity routine);
}
