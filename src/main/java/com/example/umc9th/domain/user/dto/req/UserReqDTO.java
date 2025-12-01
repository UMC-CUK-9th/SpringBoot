package com.example.umc9th.domain.user.dto.req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class UserReqDTO {

    //10주차 래코드 타입 변경
    public record JoinDTO (
        @NotBlank
        String name,
        @Email
        String email, // 10주차 추가 dto
        @NotBlank
        String password, // 10주차 추가 dto
        @NotNull
        Gender gender,
        @NotNull
        LocalDate birth,
        @NotNull
        String address,
        @NotNull
        String specAddress,
        @ExistFoods
        List<Long> preferCategory
    ){}

    //로그인
    public record LoginDTO (
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}

}
