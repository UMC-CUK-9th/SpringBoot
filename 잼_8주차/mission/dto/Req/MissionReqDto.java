package com.example.umc9th.domain.mission.dto.Req;

import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class MissionReqDto {
    public record JoinDTO(
            @NotBlank
        Long MissioId,
            @NotNull
        String contenet,
            @NotNull
            LocalDateTime deadline,
            @NotNull
            Integer point,
            @ExistFoods
        List<Long> preferCategory

        // 사용자 주소를 string으로 받는 게 괜찮을까요?
//        String address
    ){}
}
