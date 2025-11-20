package com.example.umc9th.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

public class ReviewResDTO {

    @Builder
    @Getter
    public static class ReviewInfoDTO {
        private Long id;
        private String content;
        private Float star;
        private Long storeId;
        private Long userId;
    }

    @Builder
    @Getter
    public static class ReviewDetailDTO {
        private Long id;
        private String content;
        private Float star;
        private Long storeId;
        private String storeName;
        private Long userId;
        private String userName;
    }

    @Builder
    @Getter
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private Float star;
        private String storeName;
    }
}
