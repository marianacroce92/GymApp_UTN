package com.example.AppGimnasio.userLevelTest.repository;

import com.example.AppGimnasio.userLevelTest.domain.UserLevelTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLevelTestRepository extends JpaRepository<UserLevelTestEntity, Integer> {
}
