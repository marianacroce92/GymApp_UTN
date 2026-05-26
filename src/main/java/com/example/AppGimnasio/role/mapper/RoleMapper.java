package com.example.AppGimnasio.role.mapper;

import com.example.AppGimnasio.role.domain.RoleEntity;
import com.example.AppGimnasio.role.dto.RoleCreateRequest;
import com.example.AppGimnasio.role.dto.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    RoleEntity toEntity(RoleCreateRequest request);

    RoleResponse toResponse(RoleEntity entity);
}
