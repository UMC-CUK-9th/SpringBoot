package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class MissionResDTO {

    @Builder
    @Getter
    public static class MissionInfoDTO {
        private Long id;
        private LocalDate deadline;
        private Integer point;
        private String condition;
        private Long storeId;
    }

    @Builder
    @Getter
    public static class MissionDetailDTO {
        private Long id;
        private LocalDate deadline;
        private Integer point;
        private String condition;
        private Long storeId;
        private String storeName;
    }

    @Builder
    @Getter
    public static class CreateMissionResultDTO {
        private Long missionId;
        private Integer point;
    }

    // 8주차 과제: 미션 도전하기 API - 응답 DTO
    @Builder
    @Getter
    public static class ChallengeMissionResultDTO {
        private Long userMissionId;
        private Long missionId;
        private String storeName;
        private Integer point;
        private String status;
    }
}
