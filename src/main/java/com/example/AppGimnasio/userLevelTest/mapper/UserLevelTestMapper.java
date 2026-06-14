package com.example.AppGimnasio.userLevelTest.mapper;
import com.example.AppGimnasio.userLevelTest.domain.UserLevelTestEntity;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestRequest;
import com.example.AppGimnasio.userLevelTest.dto.UserLevelTestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserLevelTestMapper {

    @Mapping(target = "userId", source = "user.id")
    UserLevelTestResponse toDto(UserLevelTestEntity userLevelTestEntity);
    UserLevelTestEntity toEntity(UserLevelTestRequest userLevelTestRequest);
}
