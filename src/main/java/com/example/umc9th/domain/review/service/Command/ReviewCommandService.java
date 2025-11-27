package com.example.umc9th.domain.review.service.Command;

import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;

public interface ReviewCommandService {

    // 8주차 미션 - 2. 가게에 리뷰 추가하기 API
    ReviewResDTO.CreateReviewDTO createReview(Long restId, Long memberId, ReviewReqDTO.CreateReviewDTO dto);
}