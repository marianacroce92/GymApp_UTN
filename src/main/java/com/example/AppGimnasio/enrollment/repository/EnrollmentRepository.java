package com.example.AppGimnasio.enrollment.repository;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.enrollment.domain.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

    Optional<EnrollmentEntity> findByExternalId(UUID externalId);

    List<EnrollmentEntity> findByClient(ClientProfileEntity client);
}
