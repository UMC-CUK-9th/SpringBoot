package com.example.umc9th.domain.review.converter;


import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {

    // 8주차 미션 - 2. 가게에 리뷰 추가하기 API
    public static Review toEntity(Member member, Restaurant restaurant, ReviewReqDTO.CreateReviewDTO dto) {
        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .grade(dto.getGrade())
                .comment(dto.getComment())
                .build();
    }

    public static ReviewResDTO.CreateReviewDTO toCreateDTO(Review review) {
        return ReviewResDTO.CreateReviewDTO.builder()
                .memberId(review.getMember().getId())
                .restId(review.getRestaurant().getId())
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API
    // 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API
    // Page<Review> → ReviewPreViewListDTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(Page<Review> result) {
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(
                        result.getContent().stream()
                                .map(ReviewConverter::toReviewPreviewDTO)
                                .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    // Review → ReviewPreViewDTO
    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(Review review) {
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .nickname(review.getMember().getNickname())  // Member 엔티티의 nickname
                .grade(review.getGrade())
                .comment(review.getComment())                // 상세 내용
                .createdAt(LocalDate.from(review.getCreatedAt())) // BaseEntity의 createdAt(LocalDateTime) → LocalDate
                .build();
    }
}