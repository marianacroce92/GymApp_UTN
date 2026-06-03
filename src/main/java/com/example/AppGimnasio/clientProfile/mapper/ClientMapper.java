package com.example.AppGimnasio.clientProfile.mapper;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.clientProfile.dto.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "userExternalId", source = "user.externalId")

    @Mapping(target = "username", source = "user.userName")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")

    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "experienceLevel", source = "experienceLevel")
    ClientResponse toResponse(ClientProfileEntity entity);
}
