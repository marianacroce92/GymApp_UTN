package com.example.AppGimnasio.role.controller;

import com.example.AppGimnasio.role.dto.RoleCreateRequest;
import com.example.AppGimnasio.role.dto.RoleResponse;
import com.example.AppGimnasio.role.service.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleResponse create(@RequestBody @Valid RoleCreateRequest request) {
        return roleService.create(request);
    }

    @GetMapping
    public List<RoleResponse> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{externalId}")
    public RoleResponse findByExternalId(@PathVariable UUID externalId) {
        return roleService.findByExternalId(externalId);
    }
}
