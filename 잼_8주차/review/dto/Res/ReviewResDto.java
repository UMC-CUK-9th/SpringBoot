package com.example.umc9th.domain.review.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDto {
    @Builder
    public record JoinDTO(
            Long storeId,
            Long userId,
            String content,
            Float star,
            LocalDateTime createdAt
    ){}
}
