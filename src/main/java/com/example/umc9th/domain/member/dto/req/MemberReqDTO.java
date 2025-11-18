package com.example.umc9th.domain.member.dto.req;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;
import java.util.List;

// 8주차 예제 - 회원가입 API
public class MemberReqDTO {

    public record JoinDTO(
            @NotBlank(message = "이름은 필수입니다.")
            String name,
            @NotNull(message = "성별은 필수입니다.")
            Gender gender,
            @NotNull(message = "생일은 필수입니다.")
            LocalDate birth,
            @NotNull(message = "주소는 필수입니다.")
            String address,
            @ExistFoods
            List<Long> preferCategory
    ){}
}
