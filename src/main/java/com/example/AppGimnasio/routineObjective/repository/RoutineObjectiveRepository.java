package com.example.AppGimnasio.clientProfile.repository;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientProfileEntity, Long> {

    Optional<ClientProfileEntity> findByUserExternalId(UUID userExternalId);

    boolean existsByUserExternalId(UUID userExternalId);
}