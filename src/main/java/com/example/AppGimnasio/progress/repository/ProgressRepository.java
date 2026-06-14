package com.example.AppGimnasio.progress.repository;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.progress.domain.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {

    Optional<ProgressEntity> findByExternalId(UUID externalId);

    List<ProgressEntity> findByClient(ClientProfileEntity client);
}
