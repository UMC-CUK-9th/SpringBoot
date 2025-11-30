package com.example.umc9th.domain.user.dto.Res;

import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.repository.UserMissionRepository;
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

    public static UserMissionRepository from(UserMission um) {
        return new UserMissionResDto(
                um.getMission().getId(),
                um.getMission().getPoint()
        );
    }
}
