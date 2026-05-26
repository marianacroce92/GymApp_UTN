package com.example.AppGimnasio.role.dto;

import com.example.AppGimnasio.role.domain.RoleName;

import java.util.UUID;

public record RoleResponse (

        UUID externalId,
        RoleName name
){}
