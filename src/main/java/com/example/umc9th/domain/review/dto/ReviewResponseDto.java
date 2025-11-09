package com.example.umc9th.domain.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String restaurantName;
    private int grade;
    private String content;
}