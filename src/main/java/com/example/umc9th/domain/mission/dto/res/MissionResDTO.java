package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

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

    // 9주차 미션 - 특정 가게의 미션 목록 응답 DTO
    @Builder
    @Getter
    public static class StoreMissionListDTO {
        private List<StoreMissionDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    // 9주차 미션 - 특정 가게의 미션 단건 DTO
    @Builder
    @Getter
    public static class StoreMissionDTO {
        private Long missionId;
        private Integer point;
        private String missionSpec;
        private LocalDate deadline;
    }

    // 9주차 미션 - 내가 진행중인 미션 목록 응답 DTO
    @Builder
    @Getter
    public static class MyChallengingMissionListDTO {
        private List<MyChallengingMissionDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    // 9주차 미션 - 내가 진행중인 미션 단건 DTO
    @Builder
    @Getter
    public static class MyChallengingMissionDTO {
        private Long userMissionId;
        private Long missionId;
        private String storeName;
        private Integer point;
        private String missionSpec;
        private LocalDate deadline;
    }
}
