package com.example.demo.domain.members.dto;

import com.example.demo.domain.members.enums.Gender;
import com.example.demo.global.annotation.ExistPreferences;
import com.example.demo.global.auth.enums.SocialType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {

    public record JoinDto(
            @NotBlank
            String name,
            @Email
            String email,
            @NotBlank
            String password,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotBlank
            String address,
            @NotNull
            String nickname,
            @Min(0)
            @NotNull
            Integer point,
            @ExistPreferences
            List<Long> preferCategory,
            @NotNull
            SocialType logType
    ){}
}
