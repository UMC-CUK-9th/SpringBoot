package com.example.demo.domain.reviews.controller;

import com.example.demo.Paging.PageParam;
import com.example.demo.Paging.PageParamDto;
import com.example.demo.domain.reviews.Services.Command.ReviewCommandService;
import com.example.demo.domain.reviews.Services.ReviewQueryService;
import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.domain.reviews.exception.code.ReviewSuccessCode;
import com.example.demo.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.spi.LocaleNameProvider;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    // 리뷰 검색 (Query Dsl)
    @GetMapping("/search")
    public ApiResponse<ReviewResDto.ReviewList> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        return ApiResponse.success(
                ReviewSuccessCode.REVIEW_SEARCH_SUCCESS,
                reviewQueryService.searchReview(type, query)
        );
    }

    // 리뷰 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ReviewResDto.ReviewInfo> createReview(
            @RequestBody @Valid ReviewReqDto request
    ) {
        ReviewResDto.ReviewInfo result = reviewCommandService.createReview(request);
        return ApiResponse.success(ReviewSuccessCode.REVIEW_CREATE_SUCCESS, result);
    }

    // 내가 작성한 리뷰 조회 (페이징)
    @GetMapping("/my/{memberId}")
    public ApiResponse<ReviewResDto.ReviewList> myReviews(
            @PageParam PageParamDto pageParam,
            @PathVariable Long memberId
    ) {
        ReviewResDto.ReviewList result =
                reviewCommandService.findReviewsByUser(memberId, pageParam.getPage(), pageParam.getSize());
        return ApiResponse.success(ReviewSuccessCode.REVIEW_SEARCH_SUCCESS, result);
    }

    // 특정 가게의 리뷰 조회 (페이징)
    @GetMapping("/stores/{storeId}")
    public ApiResponse<ReviewResDto.ReviewList> storesReviews(
            @Valid
            @PageParam PageParamDto pageParam,
            @PathVariable Long storeId
    ) {
        ReviewResDto.ReviewList result =
                reviewCommandService.findReviewsByStore(storeId, pageParam.getPage(), pageParam.getSize());
        return ApiResponse.success(ReviewSuccessCode.REVIEW_SEARCH_SUCCESS, result);

    }
}
