package com.example.AppGimnasio.progress.service;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.clientProfile.repository.ClientRepository;
import com.example.AppGimnasio.common.exception.ClientNotFoundException;
import com.example.AppGimnasio.common.exception.ProgressNotFoundException;
import com.example.AppGimnasio.progress.domain.ProgressEntity;
import com.example.AppGimnasio.progress.dto.ProgressCreateRequest;
import com.example.AppGimnasio.progress.dto.ProgressResponse;
import com.example.AppGimnasio.progress.mapper.ProgressMapper;
import com.example.AppGimnasio.progress.repository.ProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressService implements IProgressService {

    private final ProgressRepository progressRepository;
    private final ClientRepository clientRepository;
    private final ProgressMapper progressMapper;

    @Override
    public ProgressResponse create(ProgressCreateRequest request) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(request.clientUserExternalId())
                .orElseThrow(() ->
                        new ClientNotFoundException("Perfil de cliente no encontrado."));

        ProgressEntity progress = progressMapper.toEntity(request);
        progress.setClient(client);

        progress = progressRepository.save(progress);

        return progressMapper.toResponse(progress);
    }

    @Override
    public List<ProgressResponse> findAll() {
        return progressRepository.findAll()
                .stream()
                .map(progressMapper::toResponse)
                .toList();
    }

    @Override
    public ProgressResponse findByExternalId(UUID externalId) {
        ProgressEntity progress = progressRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new ProgressNotFoundException("Registro de progreso no encontrado."));
        return progressMapper.toResponse(progress);
    }

    @Override
    public List<ProgressResponse> findByClient(UUID clientUserExternalId) {
        ClientProfileEntity client = clientRepository
                .findByUserExternalId(clientUserExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException("Perfil de cliente no encontrado."));
        return progressRepository.findByClient(client)
                .stream()
                .map(progressMapper::toResponse)
                .toList();
    }

    @Override
    public void delete(UUID externalId) {
        ProgressEntity progress = progressRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new ProgressNotFoundException("Registro de progreso no encontrado."));
        progressRepository.delete(progress);
    }
}
