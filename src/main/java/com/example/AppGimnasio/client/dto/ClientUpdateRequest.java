package com.example.AppGimnasio.client.dto;

public record ClientUpdateRequest(

        Double weight,

        Double height,

        Integer age,

        String experienceLevel
){}
