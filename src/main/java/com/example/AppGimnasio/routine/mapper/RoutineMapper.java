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
    RoutineEntity toEntity(
            RoutineCreateRequest request
    );

    @Mapping(target = "trainerUserExternalId", source = "trainer.user.externalId")

    @Mapping(target = "trainerUsername",
            expression = "java(entity.getTrainer() != null ? entity.getTrainer().getUser().getUserName() : null)"
    )
    RoutineResponse toResponse(
            RoutineEntity entity
    );
}

