package com.example.umc9th.domain.user.dto.Req;

import com.example.umc9th.domain.review.enums.Address;
import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
public class UserReqDto {

    public record JoinDTO(
            @NotBlank
            String name,
            @Email
            String email, // 추가된 속성
            @NotBlank
            String password, // 추가된 속성
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            Address address,
            @NotNull
            String specAddress,
            @ExistFoods
            List<Long> preferCategory
    ) {}

    public record CreateUser (
            String email,
        String name,
        String password,
         List<Long> preferCategory
    ){};

    // 로그인
    public record LoginDTO(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
//
//    public record JoinDTO(
//            @NotBlank
//        String name,
//            @NotNull
//        Gender gender,
//            @NotNull
//        LocalDate birth,
//            @NotNull
//        String specAddress,
//        @ExistFoods
//        List<Long> preferCategory
//    ){}
}
