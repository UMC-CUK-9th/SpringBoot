package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.CreateReviewResultDTO createReview(ReviewReqDTO.CreateReviewDTO req);
    // 8주차 과제: 가게에 리뷰 추가하기 API
    ReviewResDTO.CreateReviewResultDTO createReviewForStore(Long storeId, ReviewReqDTO.CreateReviewDTO req);
    void updateReview(Long reviewId, ReviewReqDTO.UpdateReviewDTO req);
    void deleteReview(Long reviewId);
}
