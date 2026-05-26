package com.example.AppGimnasio.userRole.service;

import com.example.AppGimnasio.common.exception.RoleNotFoundException;
import com.example.AppGimnasio.common.exception.UserNotFoundException;
import com.example.AppGimnasio.common.exception.UserRoleAlreadyExistsException;
import com.example.AppGimnasio.role.domain.RoleEntity;
import com.example.AppGimnasio.role.repository.RoleRepository;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.repository.UserRepository;
import com.example.AppGimnasio.userRole.domain.UserRoleEntity;
import com.example.AppGimnasio.userRole.dto.AssignRoleRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleCreateRequest;
import com.example.AppGimnasio.userRole.dto.UserRoleResponse;
import com.example.AppGimnasio.userRole.mapper.UserRoleMapper;
import com.example.AppGimnasio.userRole.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleService implements IUserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserRoleMapper userRoleMapper;

    @Override
    public UserRoleResponse assignRole(
            UserRoleCreateRequest request
    ) {

        UserEntity user = userRepository
                .findByExternalIdAndDeletedAtIsNull(
                        request.userExternalId()
                )
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."
                        ));

        RoleEntity role = roleRepository
                .findByExternalId(
                        request.roleExternalId()
                )
                .orElseThrow(() ->
                        new RoleNotFoundException("Rol no encontrado."
                        ));
        if(userRoleRepository.existsByUserAndRole(user, role))
            throw new UserRoleAlreadyExistsException(
                    "El usuario ya posee ese rol."
            );

        UserRoleEntity userRole =
                UserRoleEntity.builder()
                        .user(user)
                        .role(role)
                        .build();

        userRole = userRoleRepository.save(userRole);

        return userRoleMapper.toResponse(userRole);
    }

    @Override
    public UserRoleResponse assignRoleByName(
            UUID userExternalId,
            AssignRoleRequest assignRoleRequest
    ) {
        UserEntity user = userRepository
                .findByExternalIdAndDeletedAtIsNull(userExternalId)
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."));

        RoleEntity role = roleRepository
                .findByName(assignRoleRequest.roleName())
                .orElseThrow(() ->
                        new RoleNotFoundException("Rol no encontrado."));

        if(userRoleRepository.existsByUserAndRole(user, role))
            throw new UserRoleAlreadyExistsException("El usuario ya posee ese rola.");

        UserRoleEntity userRole = UserRoleEntity.builder()
                .user(user)
                .role(role)
                .build();

        userRole = userRoleRepository.save(userRole);

        return userRoleMapper.toResponse(userRole);
    }

    @Override
    public List<UserRoleResponse> findRolesByUser(
            UUID userExternalId
    ) {

        UserEntity user = userRepository
                .findByExternalIdAndDeletedAtIsNull(
                        userExternalId
                )
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."
                        ));

        return  userRoleRepository.findByUser(user)
                .stream()
                .map(userRoleMapper::toResponse)
                .toList();
    }

    @Override
    public void removeRole(UUID externalId) {

        userRoleRepository.deleteByExternalId(
                externalId
        );
    }
}
