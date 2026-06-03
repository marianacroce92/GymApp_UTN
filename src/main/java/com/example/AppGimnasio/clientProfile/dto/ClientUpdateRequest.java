package com.example.AppGimnasio.clientProfile.dto;

public record ClientUpdateRequest(

        Double weight,

        Double height,

        Integer age,

        String experienceLevel
){}
