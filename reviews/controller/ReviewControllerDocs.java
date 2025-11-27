package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.global.apiPayLoad.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewControllerDocs {

    @Operation(summary = "내가 작성한 리뷰 목록",
            description = "사용자가 작성한 리뷰 목록을 페이지 단위로 반환합니다. page는 1부터 시작합니다.")
    @GetMapping("/my/{memberId}")
    ApiResponse<ReviewResDto.ReviewList> myReviews(
            @Parameter(description = "페이지 번호 (1 이상)", required = true)
            @RequestParam(defaultValue = "1") int page,

            @Parameter(description = "페이지 크기", required = false)
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "사용자 아이디", required = true)
            @RequestParam Long memberId
    );

    @Operation(summary = "특정 가게의 리뷰 목록",
            description = "특정 가게의 리뷰 목록을 페이지 단위로 반환합니다. page는 1부터 시작합니다.")
    @GetMapping("/stores/{storeId}")
    ApiResponse<ReviewResDto.ReviewList> storeReviews(
            @Parameter(description = "페이지 번호 (1 이상)", required = true)
            @RequestParam(defaultValue = "1") int page,

            @Parameter(description = "페이지 크기", required = false)
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "가게 아이디", required = true)
            @RequestParam Long storeId
    );
}
