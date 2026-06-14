package com.example.AppGimnasio.routine.mapper;

import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routine.dto.RoutineCreateRequest;
import com.example.AppGimnasio.routine.dto.RoutineResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutineMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "trainer", ignore = true)
    @Mapping(target = "routineObjectives", ignore = true)
    RoutineEntity toEntity(
            RoutineCreateRequest request
    );

    @Mapping(target = "trainerUserExternalId", source = "trainer.user.externalId")
    @Mapping(target = "trainerUsername",
            expression = "java(entity.getTrainer() != null ? entity.getTrainer().getUser().getUserName() : null)"
    )
    @Mapping(target = "objectiveId", expression = "java(extractObjectiveId(entity))")
    @Mapping(target = "objectiveName", expression = "java(extractObjectiveName(entity))")
    RoutineResponse toResponse(
            RoutineEntity entity
    );

    default Long extractObjectiveId(RoutineEntity entity) {
        if (entity.getRoutineObjectives() == null || entity.getRoutineObjectives().isEmpty())
            return null;
        return entity.getRoutineObjectives().get(0).getObjective().getId();
    }

    default String extractObjectiveName(RoutineEntity entity) {
        if (entity.getRoutineObjectives() == null || entity.getRoutineObjectives().isEmpty())
            return null;
        return entity.getRoutineObjectives().get(0).getObjective().getName();
    }
}