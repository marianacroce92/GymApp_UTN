package com.example.AppGimnasio.userLevelTest.dto;

import jakarta.validation.constraints.NotNull;

public record UserLevelTestRequest(

        @NotNull
        Integer userId

) {}