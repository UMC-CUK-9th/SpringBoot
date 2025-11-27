package com.example.demo.domain.reviews.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
public class ReviewResDto {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewInfo {
        private Long id;
        private String storeName;
        private Float rating;
        private String content;
        private List<String> imageUrls;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReviewList {
        private List<ReviewInfo> reviews;
    }
}
