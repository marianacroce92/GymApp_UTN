package com.example.AppGimnasio.objective.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObjectiveUpdateRequest {

    @NotBlank(message = "Objective name is required")
    private String name;
}