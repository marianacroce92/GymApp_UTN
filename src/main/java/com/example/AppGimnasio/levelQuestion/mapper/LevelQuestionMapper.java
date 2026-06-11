package com.example.AppGimnasio.levelQuestion.mapper;

import com.example.AppGimnasio.levelQuestion.domain.LevelQuestionEntity;
import com.example.AppGimnasio.levelQuestion.dto.LevelQuestionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelQuestionMapper {

    LevelQuestionResponse toDto(LevelQuestionEntity entity);
}