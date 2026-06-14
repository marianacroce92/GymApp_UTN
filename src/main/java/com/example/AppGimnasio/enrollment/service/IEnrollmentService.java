package com.example.AppGimnasio.enrollment.service;

import com.example.AppGimnasio.enrollment.dto.EnrollmentCreateRequest;
import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;

import java.util.List;
import java.util.UUID;

public interface IEnrollmentService {

    EnrollmentResponse create(EnrollmentCreateRequest request);

    List<EnrollmentResponse> findAll();

    EnrollmentResponse findByExternalId(UUID externalId);

    List<EnrollmentResponse> findByClient(UUID clientUserExternalId);

    EnrollmentResponse cancel(UUID externalId);
}
