package com.example.AppGimnasio.progress.service;

import com.example.AppGimnasio.progress.dto.ProgressCreateRequest;
import com.example.AppGimnasio.progress.dto.ProgressResponse;

import java.util.List;
import java.util.UUID;

public interface IProgressService {

    ProgressResponse create(ProgressCreateRequest request);

    List<ProgressResponse> findAll();

    ProgressResponse findByExternalId(UUID externalId);

    List<ProgressResponse> findByClient(UUID clientUserExternalId);

    void delete(UUID externalId);
}
