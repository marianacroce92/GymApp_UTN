package com.example.AppGimnasio.clientProfile.service;

import com.example.AppGimnasio.clientProfile.dto.ClientCreateRequest;
import com.example.AppGimnasio.clientProfile.dto.ClientResponse;
import com.example.AppGimnasio.clientProfile.dto.ClientUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IClientService {

    ClientResponse create(ClientCreateRequest request);

    List<ClientResponse> findAll();

    ClientResponse findByUserExternalId(UUID userExternalId);

    ClientResponse update(UUID userExternalId, ClientUpdateRequest request);

    void delete(UUID userExternalId);
}
