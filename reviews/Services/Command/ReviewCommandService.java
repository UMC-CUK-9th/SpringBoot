package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.reviews.dto.ReviewReqDto;
import com.example.demo.domain.reviews.dto.ReviewResDto; // 응답 DTO import

public interface ReviewCommandService {
    ReviewResDto.ReviewInfo createReview(ReviewReqDto request);
}
