package com.example.umc9th.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class ReviewResDTO {
    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ){}

    @Builder
    @Getter
    public static class CreateReviewResultDTO {
        private Long reviewId;
        private Float star;
        private String storeName;
    }

    // 9주차 미션 - 내가 작성한 리뷰 목록 응답 DTO
    @Builder
    @Getter
    public static class MyReviewListDTO {
        private List<MyReviewDTO> reviewList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    // 9주차 미션 - 내가 작성한 리뷰 단건 DTO
    @Builder
    @Getter
    public static class MyReviewDTO {
        private Long reviewId;
        private String storeName;
        private Float star;
        private String content;
        private LocalDate createdAt;
    }
}
