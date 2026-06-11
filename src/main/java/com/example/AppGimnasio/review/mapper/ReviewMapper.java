package com.example.AppGimnasio.review.mapper;

import com.example.AppGimnasio.review.domain.ReviewEntity;
import com.example.AppGimnasio.review.dto.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "trainerId", source = "trainer.id")
    ReviewResponse toResponse(ReviewEntity entity);
}