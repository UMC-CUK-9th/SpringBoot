package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;

public class ReviewConverter {

    // Review Entity -> 기본 정보 DTO 변환
    public static ReviewResDTO.ReviewInfoDTO toReviewInfoDTO(Review review) {
        return ReviewResDTO.ReviewInfoDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .star(review.getStar())
                .storeId(review.getStore().getId())
                .userId(review.getUser().getId())
                .build();
    }

    // Review Entity -> 상세 정보 DTO 변환
    public static ReviewResDTO.ReviewDetailDTO toReviewDetailDTO(Review review) {
        return ReviewResDTO.ReviewDetailDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .star(review.getStar())
                .storeId(review.getStore().getId())
                .storeName(review.getStore().getName())
                .userId(review.getUser().getId())
                .userName(review.getUser().getName())
                .build();
    }

    // Review Entity -> 생성 결과 DTO 변환
    public static ReviewResDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .star(review.getStar())
                .storeName(review.getStore().getName())
                .build();
    }
}
