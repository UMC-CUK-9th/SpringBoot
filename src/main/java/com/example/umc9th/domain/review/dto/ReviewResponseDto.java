package com.example.umc9th.domain.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private String restaurantName;
    private Integer grade;
    private String content;

    public ReviewResponseDto(String restaurantName, Integer grade, String content) {
        this.restaurantName = restaurantName;
        this.grade = grade;
        this.content = content;
    }
}