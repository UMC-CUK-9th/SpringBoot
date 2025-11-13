package com.example.umc9th.domain.user.dto.res;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class UserResDTO {

    @Builder
    @Getter
    public static class UserInfoDTO {
        private Long id;
        private String name;
        private Gender gender;
        private LocalDate birth;
        private String address;
    }

    @Builder
    @Getter
    public static class UserDetailDTO {
        private Long id;
        private String name;
        private Gender gender;
        private LocalDate birth;
        private String address;
        private String socialUid;
        private SocialType socialType;
    }

    @Builder
    @Getter
    public static class CreateUserResultDTO {
        private Long userId;
        private String name;
        private SocialType socialType;
    }
}
