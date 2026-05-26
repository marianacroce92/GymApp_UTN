package com.example.AppGimnasio.userRole.dto;

import com.example.AppGimnasio.role.domain.RoleName;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRoleResponse (

        UUID externalId,
        String username,
        String firstName,
        String lastName,
        RoleName roleName,
        LocalDateTime createdAt
){}
