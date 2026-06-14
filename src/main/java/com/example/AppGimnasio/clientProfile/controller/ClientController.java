package com.example.AppGimnasio.clientProfile.controller;

import com.example.AppGimnasio.clientProfile.dto.ClientCreateRequest;
import com.example.AppGimnasio.clientProfile.dto.ClientResponse;
import com.example.AppGimnasio.clientProfile.dto.ClientUpdateRequest;
import com.example.AppGimnasio.clientProfile.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponse create(
            @RequestBody @Valid ClientCreateRequest request

    ) {

        return  clientService.create(request);
    }

    @GetMapping
    public List<ClientResponse> findAll() {

        return  clientService.findAll();
    }

    @GetMapping("/{userExternalId}")
    public ClientResponse findByUserExternalId(
            @PathVariable UUID userExternalId
    ) {

        return  clientService.findByUserExternalId(
                userExternalId
        );
    }

    @PutMapping("/{userExternalId}")
    public ClientResponse update(
            @PathVariable UUID userExternalId,
            @RequestBody @Valid ClientUpdateRequest request
    ) {

        return clientService.update(
                userExternalId,
                request
        );
    }

    @DeleteMapping("/{userExternalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID userExternalId
    ) {
        clientService.delete(userExternalId);
    }
}
