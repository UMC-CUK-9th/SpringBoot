package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryService {
    List<Review> searchReview(
            String filter,
            String type
    ) throws Exception;

    ReviewResDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    );

    // 9주차 미션 - 내가 작성한 리뷰 목록 조회
    ReviewResDTO.MyReviewListDTO getMyReviews(Long userId, Integer page);
}
