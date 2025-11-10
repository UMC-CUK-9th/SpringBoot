package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.Services.Command.ReviewCommandService;
import com.example.demo.domain.reviews.Services.ReviewQueryService;
import com.example.demo.domain.reviews.dto.ReviewRequestDto;
import com.example.demo.domain.reviews.dto.ReviewsResponseDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.stores.repository.StoreRepository;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.domain.users.repository.UserRepository;
import com.example.demo.global.apiPayLoad.ApiResponse;
import com.example.demo.global.apiPayLoad.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    // 리뷰 필터링 조회 (Query Service 사용)
    @GetMapping("/search")
    public ApiResponse<List<ReviewsResponseDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        // Query Service 호출
        List<ReviewsResponseDto> results = reviewQueryService.searchReview(type, query);
        return ApiResponse.success(GeneralSuccessCode.OK, results);
    }

    // 리뷰 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ReviewsResponseDto> createReview(
            @RequestBody ReviewRequestDto request
    ) {
        Users user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Stores store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));
        ;

        // Command Service 호출
        Reviews createdReview = reviewCommandService.createReview(
                user,
                store,
                request.getContent(),
                request.getRating()
        );

        // 생성 후 응답 DTO로 변환
        ReviewsResponseDto response = ReviewsResponseDto.builder()
                .id(createdReview.getReviewId())
                .content(createdReview.getContent())
                .rating(createdReview.getRating())
                .storeName(createdReview.getStores().getName())
                .build();

        return ApiResponse.success(GeneralSuccessCode.OK, response);
    }
}
