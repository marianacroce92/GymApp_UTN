package com.example.AppGimnasio.userRole.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserRoleCreateRequest (

        @NotNull UUID userExternalId,

        @NotNull UUID roleExternalId
        )
{}
