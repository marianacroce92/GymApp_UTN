package com.example.AppGimnasio.enrollment.service;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.clientProfile.repository.ClientRepository;
import com.example.AppGimnasio.common.exception.ClientNotFoundException;
import com.example.AppGimnasio.common.exception.EnrollmentNotFoundException;
import com.example.AppGimnasio.common.exception.RoutineNotFoundException;
import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import com.example.AppGimnasio.enrollment.domain.EnrollmentStatus;
import com.example.AppGimnasio.enrollment.dto.EnrollmentCreateRequest;
import com.example.AppGimnasio.enrollment.dto.EnrollmentResponse;
import com.example.AppGimnasio.enrollment.mapper.EnrollmentMapper;
import com.example.AppGimnasio.enrollment.repository.EnrollmentRepository;
import com.example.AppGimnasio.routine.domain.RoutineEntity;
import com.example.AppGimnasio.routine.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements IEnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final ClientRepository clientRepository;
    private final RoutineRepository routineRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentResponse create(EnrollmentCreateRequest request) {

        ClientProfileEntity client = clientRepository
                .findByUserExternalId(request.clientUserExternalId())
                .orElseThrow(() ->
                        new ClientNotFoundException("Perfil de cliente no encontrado."));

        RoutineEntity routine = routineRepository
                .findByExternalId(request.routineExternalId())
                .orElseThrow(() ->
                        new RoutineNotFoundException("Rutina no encontrada."));

        EnrollmentEntity enrollment = EnrollmentEntity.builder()
                .client(client)
                .routine(routine)
                .build();

        enrollment = enrollmentRepository.save(enrollment);

        return enrollmentMapper.toResponse(enrollment);
    }

    @Override
    public List<EnrollmentResponse> findAll() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollmentMapper::toResponse)
                .toList();
    }

    @Override
    public EnrollmentResponse findByExternalId(UUID externalId) {
        EnrollmentEntity enrollment = enrollmentRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new EnrollmentNotFoundException("Inscripción no encontrada."));
        return enrollmentMapper.toResponse(enrollment);
    }

    @Override
    public List<EnrollmentResponse> findByClient(UUID clientUserExternalId) {
        ClientProfileEntity client = clientRepository
                .findByUserExternalId(clientUserExternalId)
                .orElseThrow(() ->
                        new ClientNotFoundException("Perfil de cliente no encontrado."));
        return enrollmentRepository.findByClient(client)
                .stream()
                .map(enrollmentMapper::toResponse)
                .toList();
    }

    @Override
    public EnrollmentResponse cancel(UUID externalId) {
        EnrollmentEntity enrollment = enrollmentRepository
                .findByExternalId(externalId)
                .orElseThrow(() ->
                        new EnrollmentNotFoundException("Inscripción no encontrada."));
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        enrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toResponse(enrollment);
    }
}
