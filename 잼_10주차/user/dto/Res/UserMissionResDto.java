package com.example.umc9th.domain.user.dto.Res;

import com.example.umc9th.domain.user.entity.mapping.UserMission;
import lombok.Builder;

import java.time.LocalDateTime;

public class UserMissionResDto {

    @Builder
    public record CreateDTO(
            Long userMissionId,
            Long userId,
            Long storeId,
            Long missionId,
            LocalDateTime createdAt
    ) {}

    // UserMission -> CreateDTO 로 변환
    public static CreateDTO from(UserMission um) {
        return CreateDTO.builder()
                .userMissionId(um.getId())
                .userId(um.getUser().getId())
                .storeId(um.getMission().getStore().getId())
                .missionId(um.getMission().getId())
                .createdAt(um.getCreatedAt())
                .build();
    }
}
