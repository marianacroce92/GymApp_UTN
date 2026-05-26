package com.example.AppGimnasio.client.service;

import com.example.AppGimnasio.client.domain.ClientProfileEntity;
import com.example.AppGimnasio.client.dto.ClientCreateRequest;
import com.example.AppGimnasio.client.dto.ClientResponse;
import com.example.AppGimnasio.client.dto.ClientUpdateRequest;
import com.example.AppGimnasio.client.mapper.ClientMapper;
import com.example.AppGimnasio.client.repository.ClientRepository;
import com.example.AppGimnasio.common.exception.ClientNotFoundException;
import com.example.AppGimnasio.common.exception.UserNotFoundException;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    private final UserRepository userRepository;

    private final ClientMapper clientMapper;

    @Override
    public ClientResponse create(ClientCreateRequest request) {

        UserEntity user = userRepository
                .findByExternalIdAndDeletedAtIsNull(
                        request.userExternalId()
                )
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "Usuario no encontrado."
                        ));

        ClientProfileEntity client =
                ClientProfileEntity.builder()
                        .user(user)
                        .weight(request.weight())
                        .height(request.height())
                        .age(request.age())
                        .experienceLevel(request.experienceLevel())
                        .build();

        client = clientRepository.save(client);

        return clientMapper.toResponse(client);
    }

    @Override
    public List<ClientResponse> findAll() {

        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toResponse)
                .toList();
    }

    @Override
    public ClientResponse findByUserExternalId(
            UUID userExternalId
    ) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(userExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Perfil de cliente no encontrado."
                        ));

        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse update(
            UUID userExternalId,
            ClientUpdateRequest request
    ) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(userExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Perfil de cliente no encontrado."
                        ));

        client.setWeight(request.weight());
        client.setHeight(request.height());
        client.setAge(request.age());
        client.setExperienceLevel(request.experienceLevel());

        client = clientRepository.save(client);

        return clientMapper.toResponse(client);
    }

    @Override
    public void delete(UUID userExternalId) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(userExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException(
                                "Perfil de cliente no encontrado."
                        ));

        clientRepository.delete(client);
    }
}
