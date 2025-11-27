package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto; // 응답 DTO import

public interface ReviewCommandService {
    ReviewResDto.ReviewInfo createReview(ReviewReqDto request);
    ReviewResDto.ReviewList findReviewsByUser(Long memberId, int page, int size);
    ReviewResDto.ReviewList findReviewsByStore(Long storeId, int page, int size);
}
