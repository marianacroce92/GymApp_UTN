package com.example.AppGimnasio.userRole.repository;

import com.example.AppGimnasio.role.domain.RoleEntity;
import com.example.AppGimnasio.user.domain.UserEntity;
import com.example.AppGimnasio.userRole.domain.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findByUser(UserEntity user);

    boolean existsByUserAndRole(
            UserEntity user,
            RoleEntity role
    );
    void deleteByExternalId(UUID externalId);
}
