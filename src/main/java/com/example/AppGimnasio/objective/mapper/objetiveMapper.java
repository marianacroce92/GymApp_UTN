package com.example.AppGimnasio.objective.mapper;

import com.example.AppGimnasio.objective.domain.ObjectiveEntity;
import com.example.AppGimnasio.objective.dto.response.ObjectiveResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectiveMapper {

    ObjectiveResponse toResponse(ObjectiveEntity entity);
}