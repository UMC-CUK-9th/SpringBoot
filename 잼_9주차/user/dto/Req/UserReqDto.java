package com.example.umc9th.domain.user.dto.Req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
public class UserReqDto {

    @Getter
    @NoArgsConstructor
    public static class CreateUser {
        private String email;
        private String name;
        private String password;
    }
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
