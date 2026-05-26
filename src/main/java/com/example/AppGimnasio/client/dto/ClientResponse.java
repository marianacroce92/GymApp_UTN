package com.example.AppGimnasio.client.dto;

import java.util.UUID;

public record ClientResponse(

        UUID userExternalId,

        String username,

        String firstName,

        String lastName,

        Double weight,

        Double height,

        Integer age,

        String experienceLevel
){}
