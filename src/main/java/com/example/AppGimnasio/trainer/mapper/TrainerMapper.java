package com.example.AppGimnasio.trainer.mapper;

import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import com.example.AppGimnasio.trainer.dto.TrainerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(target = "userExternalId", source = "user.externalId")

    @Mapping(target = "username", source = "user.userName")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "lastName", source = "user.lastName")

    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "verified", source = "verified")
    @Mapping(target = "instagram", source = "instagram")
    @Mapping(target = "whatsapp", source = "whatsapp")

    TrainerResponse toResponse(
            TrainerProfileEntity entity
    );
}
