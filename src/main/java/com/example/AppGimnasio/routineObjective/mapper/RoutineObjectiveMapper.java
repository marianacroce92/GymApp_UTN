package com.example.AppGimnasio.routineObjective.mapper;

import com.example.AppGimnasio.routineObjective.domain.RoutineObjectiveEntity;
import com.example.AppGimnasio.routineObjective.dto.RoutineObjectiveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutineObjectiveMapper {

    @Mapping(target = "objectiveId", source = "objective.id")
    RoutineObjectiveResponse toResponse(RoutineObjectiveEntity entity);
}