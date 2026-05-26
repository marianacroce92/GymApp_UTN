package com.example.AppGimnasio.userRole.dto;

import com.example.AppGimnasio.role.domain.RoleName;
import jakarta.validation.constraints.NotNull;

public record AssignRoleRequest(

        @NotNull
        RoleName roleName

) {
}