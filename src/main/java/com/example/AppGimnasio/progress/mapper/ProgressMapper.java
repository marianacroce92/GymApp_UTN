package com.example.AppGimnasio.progress.mapper;

import com.example.AppGimnasio.progress.domain.ProgressEntity;
import com.example.AppGimnasio.progress.dto.ProgressCreateRequest;
import com.example.AppGimnasio.progress.dto.ProgressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProgressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ProgressEntity toEntity(ProgressCreateRequest request);

    @Mapping(target = "clientUserExternalId", source = "client.user.externalId")
    @Mapping(target = "clientName",
            expression = "java(entity.getClient().getUser().getFirstName() + \" \" + entity.getClient().getUser().getLastName())")
    ProgressResponse toResponse(ProgressEntity entity);
}
