package com.example.demo.domain.reviews.controller;

import com.example.demo.domain.reviews.Services.Command.ReviewCommandService;
import com.example.demo.domain.reviews.Services.ReviewQueryService;
import com.example.demo.domain.reviews.converter.ReviewConverter;
import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.exception.ReviewException;
import com.example.demo.domain.reviews.exception.code.ReviewErrorCode;
import com.example.demo.domain.reviews.exception.code.ReviewSuccessCode;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.stores.repository.StoreRepository;
import com.example.demo.domain.users.entity.Users;
import com.example.demo.domain.users.repository.UserRepository;
import com.example.demo.global.apiPayLoad.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // 리뷰 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ReviewResDto.ReviewInfo> createReview(
            @RequestBody ReviewReqDto request
    ) {
        Users user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_EXCEPTION));

        Stores store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_EXCEPTION));

        Reviews createdReview = reviewCommandService.createReview(
                user,
                store,
                request.getContent(),
                request.getRating()
        );

        return ApiResponse.success(
                ReviewSuccessCode.REVIEW_CREATE_SUCCESS,
                ReviewConverter.toReviewInfoDTO(createdReview)
        );
    }
}
