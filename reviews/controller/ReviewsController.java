package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.Services.Command.ReviewCommandService;
import com.example.demo.domain.reviews.Services.ReviewQueryService;
import com.example.demo.domain.reviews.converter.ReviewConverter;
import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.domain.reviews.exception.code.ReviewSuccessCode;
import com.example.demo.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    // 리뷰 필터링 조회 (Query Service 사용)
    @GetMapping("/search")
    public ApiResponse<ReviewResDto.ReviewList> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        return ApiResponse.success(
                ReviewSuccessCode.REVIEW_SEARCH_SUCCESS,
                ReviewConverter.toReviewListDTO(
                        reviewQueryService.searchReview(type, query)
                )
        );
    }

    // 리뷰 작성하기
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ReviewResDto.ReviewInfo> createReview(
            @RequestBody @Valid ReviewReqDto request
    ) {
        ReviewResDto.ReviewInfo result = reviewCommandService.createReview(request);
        return ApiResponse.success(ReviewSuccessCode.REVIEW_CREATE_SUCCESS, result);
    }
}
