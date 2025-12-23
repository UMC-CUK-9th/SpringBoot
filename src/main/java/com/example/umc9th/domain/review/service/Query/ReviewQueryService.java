package com.example.umc9th.domain.review.service.Query;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;

public interface ReviewQueryService {

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API
    // 워크북 -> 특정 가게 이름 + 페이지 번호로 리뷰 목록 조회
    // ReviewResDTO.ReviewPreViewListDTO getReviewsByRestaurantName(String restName, Integer page);
    // 내 프로젝트 -> 특정 가게 Id + 페이지 번호로 리뷰 목록 조회
    ReviewResDTO.ReviewPreViewListDTO getRestReviews(Long restId, Integer page);

    // 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API
    ReviewResDTO.ReviewPreViewListDTO getMyReviews(Long memberId, Integer page);
}