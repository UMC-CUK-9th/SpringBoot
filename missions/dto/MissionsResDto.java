package com.example.demo.domain.missions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MissionsResDto {
    private missionInfo missionInfo;

    @Getter
    @Builder
    public static class missionInfo {
        private Long memberMiId;
        private Integer missionId;
        private String status;
        private LocalDateTime challengeDate;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MissionList {
        private List<MissionsResDto.missionInfo> missions;
    }
}