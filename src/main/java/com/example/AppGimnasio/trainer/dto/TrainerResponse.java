package com.example.AppGimnasio.trainer.dto;

import java.util.UUID;

public record TrainerResponse (
        UUID userExternalId,
        String username,
        String firstName,
        String lastName,
        String bio,
        Boolean verified,
        String instagram,
        String whatsapp
){}
