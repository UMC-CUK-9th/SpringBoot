package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/search")
    public List<ReviewResponse> getMyReviews(
            @RequestParam Long userId,
            @RequestParam String type,
            @RequestParam String query
    ) {
        return reviewService.searchMyReviews(userId, type, query);
    }
}
