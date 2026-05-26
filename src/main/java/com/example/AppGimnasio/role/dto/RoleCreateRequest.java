package com.example.AppGimnasio.role.dto;

import com.example.AppGimnasio.role.domain.RoleName;
import jakarta.validation.constraints.NotNull;

public record RoleCreateRequest (
        @NotNull RoleName name
){}
