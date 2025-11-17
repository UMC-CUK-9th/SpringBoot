package com.example.umc9th.domain.review.dto.Req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

// 8주차 미션 - 2. 가게에 리뷰 추가하기 API
public class ReviewReqDTO {

    @Getter
    @Setter
    @Schema(name = "ReviewCreateRequest")
    public static class CreateReviewDTO {
        @NotNull(message = "별점은 필수입니다.")
        @Min(value = 1, message = "평점은 1점 이상이어야 합니다.")
        @Max(value = 5, message = "평점은 5점 이하이어야 합니다.")
        private int grade;

        @NotBlank(message = "리뷰 내용은 필수입니다.")
        @Size(max = 500, message = "리뷰 내용은 500자 이하여야 합니다.")
        private String comment;
    }
}
