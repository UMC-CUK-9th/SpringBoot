package com.example.umc9th.domain.review.dto.Req;

import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReviewReqDto {
    public record JoinDTO(
            @NotBlank
        Long storeId,
            @NotBlank
            Long userId,
            @NotNull
        String contenet,
            @NotBlank
            Float star,
        @ExistFoods
        List<Long> preferCategory

        // 사용자 주소를 string으로 받는 게 괜찮을까요?
//        String address
    ){}
}
