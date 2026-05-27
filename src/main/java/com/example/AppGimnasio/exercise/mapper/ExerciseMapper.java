package com.example.AppGimnasio.exercise.mapper;

import com.example.AppGimnasio.exercise.domain.ExerciseEntity;
import com.example.AppGimnasio.exercise.dto.ExerciseCreateRequest;
import com.example.AppGimnasio.exercise.dto.ExerciseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    ExerciseEntity toEntity(
            ExerciseCreateRequest request
    );

    ExerciseResponse toResponse(
            ExerciseEntity entity
    );
}
