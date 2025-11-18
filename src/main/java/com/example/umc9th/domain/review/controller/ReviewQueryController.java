package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.Res.ReviewResponseDto;
import com.example.umc9th.domain.review.service.Query.ReviewQueryServiceImpl;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewQueryController {

    private final ReviewQueryServiceImpl reviewQueryService;

    // 6주차 과제 - 내가 작성한 리뷰 보기 API, QueryDSL로 구현하기
    @GetMapping("/search")
    public ApiResponse<List<ReviewResponseDto>> searchReviews(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String query
    ) {
        // 검색 조건에 따른 리뷰 목록 조회
        List<ReviewResponseDto> results = reviewQueryService.searchReview(type, query);
        // 7주차 미션 - API 응답통일 처리하기
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, results);
    }
}