package com.example.AppGimnasio.user.mapper;

import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.dto.UserCreateRequest;
import com.example.AppGimnasio.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "validatedAccount", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "passwordHash", source = "password")
    UserEntity toEntity(UserCreateRequest request);

    UserResponse toResponse(UserEntity entity);
}
