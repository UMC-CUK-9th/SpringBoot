package com.example.umc9th.domain.user.dto.res;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.domain.user.enums.SocialType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResDTO {

    @Builder
    @Getter
    public static class JoinDTO {
        private Long userId;
        private LocalDateTime createdAt;
    }

}
