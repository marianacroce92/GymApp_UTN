package com.example.AppGimnasio.role.repository;

import com.example.AppGimnasio.role.domain.RoleEntity;
import com.example.AppGimnasio.role.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByExternalId(UUID externalId);

    Optional<RoleEntity> findByName(RoleName name);

    boolean existsByName(RoleName name);
}
