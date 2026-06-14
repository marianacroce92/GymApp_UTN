package com.example.AppGimnasio.clientProfile.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClientCreateRequest(

        @NotNull UUID userExternalId,

        Double weight,

        Double height,

        Integer age,

        String experienceLevel
){}
