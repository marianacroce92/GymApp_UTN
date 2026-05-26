package com.example.AppGimnasio.user.service;

import com.example.AppGimnasio.common.exception.UserAlreadyExistsException;
import com.example.AppGimnasio.common.exception.UserNotFoundException;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.dto.UserCreateRequest;
import com.example.AppGimnasio.user.dto.UserResponse;
import com.example.AppGimnasio.user.dto.UserUpdateRequest;
import com.example.AppGimnasio.user.mapper.UserMapper;
import com.example.AppGimnasio.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserResponse create(UserCreateRequest request) {
        if (userRepository.existsByDni(request.dni()))
            throw new UserAlreadyExistsException("El número de DNI ya existe.");

        if (userRepository.existsByUserName(request.userName()))
            throw new UserAlreadyExistsException("El usuario ya existe.");

        if (userRepository.existsByEmail(request.email()))
            throw new UserAlreadyExistsException("El email ya existe.");

        UserEntity user = userMapper.toEntity(request);

        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> findAll() {

        return userRepository.findByDeletedAtIsNull()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse findByExternalId(UUID externalId){

        UserEntity user = userRepository.findByExternalIdAndDeletedAtIsNull(externalId)
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(UUID externalId, UserUpdateRequest request) {

        UserEntity user = userRepository.findByExternalIdAndDeletedAtIsNull(externalId)
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."));

        user.setUserName(request.userName());
        user.setEmail(request.email());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setBirthDay(request.birthDay());
        user.setGender(request.gender());

        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public void delete(UUID externalId) {
        UserEntity user = userRepository.findByExternalIdAndDeletedAtIsNull(externalId)
                .orElseThrow(() ->
                        new UserNotFoundException("Usuario no encontrado."));

        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
    }
}
