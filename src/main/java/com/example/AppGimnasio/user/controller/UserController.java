package com.example.AppGimnasio.user.controller;

import com.example.AppGimnasio.user.dto.UserCreateRequest;
import com.example.AppGimnasio.user.dto.UserResponse;
import com.example.AppGimnasio.user.dto.UserUpdateRequest;
import com.example.AppGimnasio.user.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(
            @RequestBody @Valid UserCreateRequest request
    ){

        return userService.create(request);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{externalId}")
    public UserResponse findByExternalId(
            @PathVariable UUID externalId
    ) {

        return userService.findByExternalId(externalId);
    }

    @PutMapping("/{externalId}")
    public UserResponse update(
            @PathVariable UUID externalId,
            @RequestBody @Valid UserUpdateRequest request
    ){

        return  userService.update(externalId, request);
    }

    @DeleteMapping("/{externalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID externalId
    ){

        userService.delete(externalId);
    }
}
