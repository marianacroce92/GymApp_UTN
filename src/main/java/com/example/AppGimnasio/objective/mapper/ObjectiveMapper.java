package com.example.AppGimnasio.objective.mapper;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import com.example.AppGimnasio.objective.dto.ObjectiveCreateRequest;
import com.example.AppGimnasio.objective.dto.ObjectiveUpdateRequest;
import com.example.AppGimnasio.objective.dto.ObjectiveResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectiveMapper {

    ObjectiveResponse toResponse(ObjectiveEntity entity);
    ObjectiveEntity toEntity(ObjectiveCreateRequest dto);
    ObjectiveEntity toEntity(ObjectiveUpdateRequest dto);
}