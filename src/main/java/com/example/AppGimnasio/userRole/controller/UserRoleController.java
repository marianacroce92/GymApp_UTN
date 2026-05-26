package com.example.AppGimnasio.userRole.controller;

import com.example.AppGimnasio.userRole.dto.AssignRoleRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleCreateRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleResponse;
import com.example.AppGimnasio.userRole.service.IUserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final IUserRoleService userRoleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRoleResponse assignRole(
            @RequestBody @Valid UserRoleCreateRequest request
    ) {

        return userRoleService.assignRole(request);
    }

    @PostMapping("/{userExternalId}/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRoleResponse assignRoleByName(
            @PathVariable UUID userExternalId,
            @RequestBody @Valid AssignRoleRequest request
    ) {
        return userRoleService.assignRoleByName(
                userExternalId, request
        );
    }

    @GetMapping("/user/{userExternalId}")
    public List<UserRoleResponse> findRolesByUser(
            @PathVariable UUID userExternalId
    ) {

        return  userRoleService.findRolesByUser(
                userExternalId
        );
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRole(
            @PathVariable UUID externalId
    ) {

        userRoleService.removeRole(externalId);
    }
}
