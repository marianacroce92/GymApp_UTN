package com.example.AppGimnasio.user.dto;

import com.example.AppGimnasio.user.domain.Gender;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record UserUpdateRequest (
        String userName,
        @Email String email,
        String firstName,
        String lastName,
        LocalDate birthDay,
        Gender gender
){}
