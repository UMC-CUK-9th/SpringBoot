package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.repository.ReviewRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    // 6주차 미션 - 내가 작성한 리뷰 보기 API (QueryDSL)
    private final ReviewRepositoryCustom reviewRepository;

    public List<ReviewResponseDto> getMyReviews(Long memberId, String restaurantName, Integer grade) {
        return reviewRepository.findMyReviews(memberId, restaurantName, grade);
    }
}