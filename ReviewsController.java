package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.Services.ReviewQueryService;
import com.example.demo.domain.reviews.dto.ReviewsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<ReviewsResponseDto> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        return reviewQueryService.searchReview(type, query);
    }
}
