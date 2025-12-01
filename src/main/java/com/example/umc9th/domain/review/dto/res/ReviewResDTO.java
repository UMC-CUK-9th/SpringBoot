package com.example.umc9th.domain.review.dto.res;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {

    // 8주차 미션 - 2. 가게에 리뷰 추가하기 API
    @Builder
    public record CreateReviewDTO(
            Long reviewId,
            Long restId,
            Long memberId,
            LocalDateTime createdAt
    ) {}

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API
    // 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API
    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    // 실제 한 개의 리뷰 정보 DTO
    @Builder
    public record ReviewPreViewDTO(
            String nickname,     // 리뷰 작성자 닉네임
            Integer grade,       // 별점
            String comment,      // 리뷰 상세 내용
            LocalDate createdAt  // 작성 날짜
    ) {}
}