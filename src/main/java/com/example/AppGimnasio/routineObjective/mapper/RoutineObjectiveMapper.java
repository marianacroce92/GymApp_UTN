package com.example.AppGimnasio.routineObjetive.mapper;

import com.example.AppGimnasio.routineObjective.domain.RoutineObjectiveEntity;
import com.example.AppGimnasio.routineObjetive.dto.RoutineObjectiveResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutineObjectiveMapper {

    @Mapping(target = "objectiveId", source = "objective.id")
    RoutineObjectiveResponse toResponse(RoutineObjectiveEntity entity);
}