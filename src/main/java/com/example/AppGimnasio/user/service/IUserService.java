package com.example.AppGimnasio.user.service;

import com.example.AppGimnasio.user.dto.UserCreateRequest;
import com.example.AppGimnasio.user.dto.UserResponse;
import com.example.AppGimnasio.user.dto.UserUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserResponse create(UserCreateRequest request);

    List<UserResponse> findAll();

    UserResponse findByExternalId(UUID externalId);

    UserResponse update(UUID externalId, UserUpdateRequest request);

    void delete(UUID externalId);
}
