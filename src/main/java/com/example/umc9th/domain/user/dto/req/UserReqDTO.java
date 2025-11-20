package com.example.umc9th.domain.user.dto.req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class UserReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDTO {
        @NotBlank
        private String name;
        @NotNull
        private Gender gender;
        @NotNull
        private LocalDate birth;
        @NotNull
        private String address;
        @NotNull
        private String specAddress;
        @ExistFoods
        private List<Long> preferCategory;
    }

}
