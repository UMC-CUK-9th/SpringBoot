package com.example.umc9th.domain.user.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserMissionResDto {
    @Builder
    public record CreateDTO(
            Long userMissionId,
            Long userId,
            Long storeId,
            Long missionId,
            LocalDateTime createAt
    ){}
}
