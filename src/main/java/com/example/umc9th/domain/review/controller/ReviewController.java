package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    /**
     * 리뷰 기본 정보 조회
     */
    @GetMapping("/{reviewId}")
    public ApiResponse<ReviewResDTO.ReviewInfoDTO> getReviewInfo(
            @PathVariable Long reviewId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.getReviewInfo(reviewId)
        );
    }

    /**
     * 리뷰 상세 정보 조회
     */
    @GetMapping("/{reviewId}/detail")
    public ApiResponse<ReviewResDTO.ReviewDetailDTO> getReviewDetail(
            @PathVariable Long reviewId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.getReviewDetail(reviewId)
        );
    }

    /**
     * 리뷰 생성
     */
    @PostMapping
    public ApiResponse<ReviewResDTO.CreateReviewResultDTO> createReview(
            @RequestBody ReviewReqDTO.CreateReviewDTO req
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                reviewCommandService.createReview(req)
        );
    }

    /**
     * 리뷰 정보 수정
     */
    @PutMapping("/{reviewId}")
    public ApiResponse<Void> updateReview(
            @PathVariable Long reviewId,
            @RequestBody ReviewReqDTO.UpdateReviewDTO req
    ) {
        reviewCommandService.updateReview(reviewId, req);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }

    /**
     * 리뷰 삭제
     */
    @DeleteMapping("/{reviewId}")
    public ApiResponse<Void> deleteReview(
            @PathVariable Long reviewId
    ) {
        reviewCommandService.deleteReview(reviewId);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }
}
