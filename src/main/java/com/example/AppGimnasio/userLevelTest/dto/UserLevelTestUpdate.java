package com.example.AppGimnasio.userLevelTest.dto;

import com.example.AppGimnasio.userLevelTest.domain.ResultLevel;
import jakarta.validation.constraints.NotNull;

public record UserLevelTestUpdate(

        @NotNull
        Integer score,

        @NotNull
        ResultLevel resultLevel

) {}