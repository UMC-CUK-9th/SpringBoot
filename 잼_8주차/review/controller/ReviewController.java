package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Review createReview(
            @RequestParam Long storeId,
            @RequestParam Long userId,
            @RequestParam int star,
            @RequestParam String detail
    ) {
        return reviewService.writeReview(storeId, userId, star, detail);
    }

    @GetMapping("/{storeId}")
    public List<Review> getReviews(@PathVariable Long storeId) {
        return reviewService.getReviewsByStoreId(storeId);
    }

    @GetMapping("/{storeId}/average")
    public Double getAverageStar(@PathVariable Long storeId) {
        return reviewService.getAverageStar(storeId);
    }
}