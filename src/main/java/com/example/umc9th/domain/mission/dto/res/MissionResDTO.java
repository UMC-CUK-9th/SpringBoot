package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
public class MissionResDTO {

    @Builder
    public record CreateDTO(
            Long missionId,
            Long restId,
            LocalDateTime deadline,
            LocalDateTime createdAt
    ) {}
}
