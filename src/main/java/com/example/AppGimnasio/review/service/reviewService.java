package com.example.AppGimnasio.review.service;

import com.example.AppGimnasio.clientProfile.domain.ClientProfileEntity;
import com.example.AppGimnasio.clientProfile.repository.ClientRepository;
import com.example.AppGimnasio.review.domain.ReviewEntity;
import com.example.AppGimnasio.review.dto.ReviewRequest;
import com.example.AppGimnasio.review.dto.ReviewResponse;
import com.example.AppGimnasio.review.dto.ReviewUpdate;
import com.example.AppGimnasio.review.mapper.ReviewMapper;
import com.example.AppGimnasio.review.repository.ReviewRepository;
import com.example.AppGimnasio.trainer.domain.TrainerProfileEntity;
import com.example.AppGimnasio.trainer.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final ClientRepository clientRepository;
    private final TrainerRepository trainerRepository;

    public ReviewResponse create(ReviewRequest request) {

        ClientProfileEntity client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        TrainerProfileEntity trainer = trainerRepository.findById(request.trainerId())
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        ReviewEntity review = ReviewEntity.builder()
                .rating(request.rating())
                .comment(request.comment())
                .client(client)
                .trainer(trainer)
                .build();

        return reviewMapper.toResponse(
                reviewRepository.save(review)
        );
    }

    public List<ReviewResponse> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::toResponse)
                .toList();
    }

    public ReviewResponse findById(Long id) {

        ReviewEntity review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        return reviewMapper.toResponse(review);
    }

    public ReviewResponse update(Long id, ReviewUpdate request) {

        ReviewEntity review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setRating(request.rating());
        review.setComment(request.comment());

        return reviewMapper.toResponse(
                reviewRepository.save(review)
        );
    }

    public void delete(Long id) {

        ReviewEntity review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        reviewRepository.delete(review);
    }
}