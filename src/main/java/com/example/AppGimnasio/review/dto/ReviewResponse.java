package com.example.AppGimnasio.review.dto;

import java.time.LocalDateTime;

public record ReviewResponse(

        Long id,

        Integer rating,

        String comment,

        LocalDateTime createdAt,

        Long clientId,

        Long trainerId

) {}