package com.example.demo.domain.reviews.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewReqDto {
    private Long userId;
    private Long storeId;
    private Float rating;
    private String content;
}

