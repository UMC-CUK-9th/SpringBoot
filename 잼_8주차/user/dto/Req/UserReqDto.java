package com.example.umc9th.domain.user.dto.Req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class UserReqDto {
    public record JoinDTO(
            @NotBlank
        String name,
            @NotNull
        Gender gender,
            @NotNull
        LocalDate birth,
            @NotNull
        String specAddress,
        @ExistFoods
        List<Long> preferCategory

        // 사용자 주소를 string으로 받는 게 괜찮을까요?
//        String address
    ){}
}
