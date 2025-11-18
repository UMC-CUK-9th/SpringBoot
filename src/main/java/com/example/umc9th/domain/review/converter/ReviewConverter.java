package com.example.umc9th.domain.review.converter;


import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;

// 8주차 미션 - 2. 가게에 리뷰 추가하기 API
public class ReviewConverter {

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
}