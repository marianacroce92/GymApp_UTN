package com.example.AppGimnasio.routineExercise.mapper;

import com.example.AppGimnasio.routineExercise.domain.RoutineExerciseEntity;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseCreateRequest;
import com.example.AppGimnasio.routineExercise.dto.RoutineExerciseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoutineExerciseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "routine", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    RoutineExerciseEntity toEntity(RoutineExerciseCreateRequest request);

    @Mapping(target = "routineExternalId", source = "routine.externalId")
    @Mapping(target = "routineTitle", source = "routine.title")
    @Mapping(target = "exerciseExternalId", source = "exercise.externalId")
    @Mapping(target = "exerciseName", source = "exercise.name")
    RoutineExerciseResponse toResponse(RoutineExerciseEntity entity);
}
