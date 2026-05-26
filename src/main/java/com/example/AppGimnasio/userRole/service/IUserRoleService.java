package com.example.AppGimnasio.userRole.service;


import com.example.AppGimnasio.userRole.dto.AssignRoleRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleCreateRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleResponse;


import java.util.List;
import java.util.UUID;

public interface IUserRoleService {

    UserRoleResponse assignRole(
            UserRoleCreateRequest request
    );

    UserRoleResponse assignRoleByName(
            UUID userExternalId, AssignRoleRequest assignRoleRequest
    );

    List<UserRoleResponse> findRolesByUser(
            UUID userExternalId
    );

    void removeRole(UUID externalId);
}
