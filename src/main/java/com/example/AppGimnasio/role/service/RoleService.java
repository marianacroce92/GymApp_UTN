package com.example.AppGimnasio.role.service;

import com.example.AppGimnasio.common.exception.RoleAlreadyExistsException;
import com.example.AppGimnasio.common.exception.RoleNotFoundException;
import com.example.AppGimnasio.role.domain.RoleEntity;
import com.example.AppGimnasio.role.dto.RoleCreateRequest;
import com.example.AppGimnasio.role.dto.RoleResponse;
import com.example.AppGimnasio.role.mapper.RoleMapper;
import com.example.AppGimnasio.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService{

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleCreateRequest request) {

        if(roleRepository.existsByName(request.name()))
            throw new RoleAlreadyExistsException("El rol ya existe.");

        RoleEntity role = roleMapper.toEntity(request);

        role = roleRepository.save(role);

        return roleMapper.toResponse(role);
    }

    @Override
    public List<RoleResponse> findAll() {

        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .toList();
    }

    @Override
    public RoleResponse findByExternalId(UUID externalId) {

        RoleEntity role = roleRepository.findByExternalId(externalId)
                .orElseThrow(() ->
                        new RoleNotFoundException("No existe un rol con el id proporcionado."));
        return roleMapper.toResponse(role);
    }
}
