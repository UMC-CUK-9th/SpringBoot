package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    // 6주차 미션 - 내가 작성한 리뷰 보기 API (QueryDSL)
    private final ReviewService reviewService;

    @GetMapping("/my")
    public ResponseEntity<List<ReviewResponseDto>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String restaurantName,
            @RequestParam(required = false) Integer grade) {

        List<ReviewResponseDto> reviews =
                reviewService.getMyReviews(memberId, restaurantName, grade);
        return ResponseEntity.ok(reviews);
    }
}