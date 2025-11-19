package com.example.umc9th.domain.user.dto.Req;

import com.example.umc9th.domain.user.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class UserMissionReqDto {
    public record CreateDTO(
            @NotBlank
            Integer id,
            @NotBlank
        String user,
            @NotNull
        Gender store,
            @NotNull
        LocalDate mission
    ){}
}
