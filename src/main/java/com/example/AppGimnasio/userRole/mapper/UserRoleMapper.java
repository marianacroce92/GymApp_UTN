package com.example.AppGimnasio.userRole.mapper;

import com.example.AppGimnasio.userRole.domain.UserRoleEntity;
import com.example.AppGimnasio.userRole.dto.UserRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    @Mapping(target = "externalId", source = "externalId")

    @Mapping(target = "username", source = "user.userName")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")

    @Mapping(target = "roleName", source = "role.name")

    @Mapping(target = "createdAt", source = "createdAt")
    UserRoleResponse toResponse(UserRoleEntity entity);
}
