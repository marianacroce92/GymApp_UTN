package com.example.AppGimnasio.role.service;

import com.example.AppGimnasio.role.dto.RoleCreateRequest;
import com.example.AppGimnasio.role.dto.RoleResponse;

import java.util.List;
import java.util.UUID;

public interface IRoleService {

    RoleResponse create(RoleCreateRequest request);

    List<RoleResponse> findAll();

    RoleResponse findByExternalId(UUID externalId);
}
