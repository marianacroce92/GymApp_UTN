package com.example.AppGimnasio.user.repository;

import com.example.AppGimnasio.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    Optional<UserEntity> findByExternalId(UUID externalId);

    Optional<UserEntity> findByExternalIdAndDeletedAtIsNull(UUID externalId);

    List<UserEntity> findByDeletedAtIsNull();

    boolean existsByDni(String dni);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}
