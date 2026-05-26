package com.example.AppGimnasio.trainer.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TrainerCreateRequest (
        @NotNull UUID userExternalId,
        String bio,
        String instagram,
        String whatsapp
){}
