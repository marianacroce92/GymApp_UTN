package com.example.AppGimnasio.history.service;

import com.example.AppGimnasio.history.dto.ClientHistoryResponse;

import java.util.UUID;

public interface IHistoryService {

    ClientHistoryResponse getClientHistory(UUID clientUserExternalId);
}
