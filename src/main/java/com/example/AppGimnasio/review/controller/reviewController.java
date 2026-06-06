package com.example.AppGimnasio.review.controller;

import com.example.AppGimnasio.review.dto.ReviewRequest;
import com.example.AppGimnasio.review.dto.ReviewResponse;
import com.example.AppGimnasio.review.dto.ReviewUpdate;
import com.example.AppGimnasio.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponse create(
            @Valid @RequestBody ReviewRequest request) {

        return reviewService.create(request);
    }

    @GetMapping
    public List<ReviewResponse> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewResponse findById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public ReviewResponse update(
            @PathVariable Long id,
            @Valid @RequestBody ReviewUpdate request) {

        return reviewService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}