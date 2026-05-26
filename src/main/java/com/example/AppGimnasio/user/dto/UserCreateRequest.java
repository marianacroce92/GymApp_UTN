package com.example.AppGimnasio.user.dto;

import com.example.AppGimnasio.user.domain.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserCreateRequest (
        @NotBlank String dni,
        @NotBlank String userName,
        @Email @NotBlank String email,
        @NotBlank String password,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull LocalDate birthDay,
        @NotNull Gender gender
){}
