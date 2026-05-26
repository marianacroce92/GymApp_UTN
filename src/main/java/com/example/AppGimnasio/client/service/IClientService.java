package com.example.AppGimnasio.client.service;

import com.example.AppGimnasio.client.dto.ClientCreateRequest;
import com.example.AppGimnasio.client.dto.ClientResponse;
import com.example.AppGimnasio.client.dto.ClientUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IClientService {

    ClientResponse create(ClientCreateRequest request);

    List<ClientResponse> findAll();

    ClientResponse findByUserExternalId(UUID userExternalId);

    ClientResponse update(UUID userExternalId, ClientUpdateRequest request);

    void delete(UUID userExternalId);
}
