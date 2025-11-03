package com.example.demo.domain.reviews.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsResponseDto {
    private Long id;
    private String content;
    private Float rating;
    private String storeName;
}
