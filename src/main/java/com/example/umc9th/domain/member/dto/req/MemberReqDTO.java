package com.example.umc9th.domain.member.dto.req;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    // 8주차 예제 - 회원가입 API
    // 10주차 예제 - 1. 간단한 로그인 및 회원가입 구현 (Session 방식)
    public record JoinDTO(
            @NotBlank(message = "이름은 필수입니다.")
            String name,
            @Email
            String email, // 추가된 속성
            @NotBlank(message = "비밀번호는 필수입니다.")
            String password, // 추가된 속성
            @NotNull(message = "성별은 필수입니다.")
            Gender gender,
            @NotNull(message = "생일은 필수입니다.")
            LocalDate birth,
            @NotNull(message = "주소는 필수입니다.")
            String address,
            @NotBlank(message = "전화번호는 필수입니다.")
            String phoneNum,
            @ExistFoods
            List<Long> preferCategory
    ){}

    // 10주차 예제 - 2. 간단한 로그인 및 회원가입 구현 (JWT Token 방식)
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
}