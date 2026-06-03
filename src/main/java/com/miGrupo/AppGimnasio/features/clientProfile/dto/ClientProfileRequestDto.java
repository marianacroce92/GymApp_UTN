package com.miGrupo.AppGimnasio.features.clientProfile.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientProfileRequestDto {
    @NotNull @NotBlank(message = "El peso debe ser obligatorio")
    private Double weight;
    @NotNull @NotBlank(message = "La altura es obligatorio")
    private Double height;
    @NotNull
    private Integer age; }
}
