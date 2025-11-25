package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.Res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
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
    public List<ReviewResDto> getReviews(@ValidPage Integer page) {
        return reviewService.getReviews(page);
    }

    @GetMapping("/{storeId}/average")
    public Double getAverageStar(@PathVariable Long storeId) {
        return reviewService.getAverageStar(storeId);
    }

    // 가게 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, ReviewService.findReview(storeName, page));
    }
}