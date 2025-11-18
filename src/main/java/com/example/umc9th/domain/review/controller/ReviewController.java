package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;
import com.example.umc9th.domain.review.service.Command.ReviewCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// 8주차 미션 - 2. 가게에 리뷰 추가하기 API
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants/{restId}/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ApiResponse<ReviewResDTO.CreateReviewDTO> createReview(
            @PathVariable Long restId,
            @RequestBody @Valid ReviewReqDTO.CreateReviewDTO request
    ) {
        var result = reviewCommandService.createReview(restId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }
}