package com.example.umc9th.domain.user.dto.req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class UserReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUserDTO {
        private String name;
        private Gender gender;
        private LocalDate birth;
        private String address;
        private String socialUid;
        private SocialType socialType;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateUserDTO {
        private String name;
        private Gender gender;
        private String address;
    }
}
