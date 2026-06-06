package com.example.AppGimnasio.userLevelTest.dto;

import com.example.AppGimnasio.userLevelTest.domain.ResultLevel;

import java.time.LocalDate;

public record UserLevelTestResponse(

        Integer id,

        Integer score,

        ResultLevel resultLevel,

        LocalDate createdAt,

        Integer userId

) {}
