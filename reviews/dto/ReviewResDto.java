package com.example.demo.domain.reviews.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReviewResDto {

    @Getter
    @Builder
    public static class ReviewInfo {
        private Long id;
        private String storeName;
        private Float rating;
        private String content;
        private List<String> imageUrls;
    }

    @Getter
    @Builder
    public static class ReviewList {
        private List<ReviewInfo> reviews;
    }
}
