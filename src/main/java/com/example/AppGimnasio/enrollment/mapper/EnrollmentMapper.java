package com.example.AppGimnasio.enrollment.mapper;

import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import com.example.AppGimnasio.enrollment.dto.EnrollmentCreateRequest;
import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "routine", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    EnrollmentEntity toEntity(EnrollmentCreateRequest request);

    @Mapping(target = "clientUserExternalId", source = "client.user.externalId")
    @Mapping(target = "clientName",
            expression = "java(entity.getClient().getUser().getFirstName() + \" \" + entity.getClient().getUser().getLastName())")
    @Mapping(target = "routineExternalId", source = "routine.externalId")
    @Mapping(target = "routineTitle", source = "routine.title")
    EnrollmentResponse toResponse(EnrollmentEntity entity);
}
