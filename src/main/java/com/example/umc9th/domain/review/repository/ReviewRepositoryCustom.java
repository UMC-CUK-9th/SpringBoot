package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<ReviewResponseDto> findMyReviews(Long memberId, String restaurantName, Integer grade);
}