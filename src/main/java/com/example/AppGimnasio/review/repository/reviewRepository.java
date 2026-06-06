package com.example.AppGimnasio.review.repository;

import com.example.AppGimnasio.review.domain.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByClientId(Long clientId);

    List<ReviewEntity> findByTrainerId(Long trainerId);

    boolean existsByClientIdAndTrainerId(Long clientId, Long trainerId);
}