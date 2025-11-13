package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;

public interface ReviewQueryService {
    ReviewResDTO.ReviewInfoDTO getReviewInfo(Long reviewId);
    ReviewResDTO.ReviewDetailDTO getReviewDetail(Long reviewId);
}
