package com.example.umc9th.domain.review.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

// 8주차 미션 - 2. 가게에 리뷰 추가하기 API
public class ReviewResDTO {

    @Builder
    public record CreateReviewDTO(
            Long reviewId,
            Long restId,
            Long memberId,
            LocalDateTime createdAt
    ) {}
}