package com.example.demo.domain.members.dto;

import com.example.demo.domain.members.enums.Gender;
import com.example.demo.global.annotation.ExistPreferences;
import com.example.demo.global.auth.enums.SocialType;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {
    public record JoinDto(
            String name,
            String nickname,
            String email,
            SocialType logType,
            Gender gender,
            LocalDate birth,
            String address,
            @ExistPreferences
            List<Long> preferCategory
    ) {}
}
