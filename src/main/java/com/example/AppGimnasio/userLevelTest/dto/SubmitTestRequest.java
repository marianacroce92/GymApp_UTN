package com.example.AppGimnasio.userLevelTest.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record SubmitTestRequest(
        @NotNull UUID userExternalId,
        @NotNull List<Integer> answerIds
) {}
