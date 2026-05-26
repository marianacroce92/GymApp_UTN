package com.example.AppGimnasio.trainer.dto;

public record TrainerUpdateRequest (
        String bio,
        Boolean verified,
        String instagram,
        String whatsapp
){}
