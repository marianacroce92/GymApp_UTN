package com.example.AppGimnasio.user.dto;

import com.example.AppGimnasio.user.domain.Gender;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse (
        UUID externalId,
        String dni,
        String userName,
        String email,
        String firstName,
        String lastName,
        LocalDate birthDay,
        Gender gender,
        Boolean validatedAccount,
        LocalDateTime createdAt
){}
