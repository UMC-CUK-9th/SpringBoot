package com.example.umc9th.domain.user.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserResDto {
    @Builder
    public record CreateDTO(
            Long userId,
            Long storeId,
            Long missionId,
            LocalDateTime createAt
    ){}

    public class JoinDTO {
    }
}
