package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.Exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;
import com.example.umc9th.domain.review.service.Command.ReviewCommandService;
import com.example.umc9th.domain.review.service.Query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.validator.ValidPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Validated
public class ReviewController implements ReviewControllerDocs {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    /**
     * 8주차 미션 - 2. 가게에 리뷰 추가하기 API
     * POST /restaurants/{restId}/reviews?memberId=1
     */
    @PostMapping("/restaurants/{restId}/reviews")
    public ApiResponse<ReviewResDTO.CreateReviewDTO> createReview(
            @PathVariable Long restId,
            @RequestParam("memberId") Long memberId,
            @RequestBody @Valid ReviewReqDTO.CreateReviewDTO request
    ) {
        var result = reviewCommandService.createReview(restId, memberId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }

    /**
     * 9주차 실습 - 특정 가게의 리뷰 목록 조회하기 API
     * GET /restaurants/{restId}/reviews?page=1
     */
    @GetMapping("/restaurants/{restId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getRestReviews(
            @PathVariable Long restId,
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        var result = reviewQueryService.getRestReviews(restId, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_FOUND, result);
    }

    /**
     * 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API
     * GET /members/{memberId}/reviews?page=1
     */
    @GetMapping("/members/{memberId}/reviews")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @PathVariable Long memberId,
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        var result = reviewQueryService.getMyReviews(memberId, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.REVIEW_FOUND, result);
    }
}