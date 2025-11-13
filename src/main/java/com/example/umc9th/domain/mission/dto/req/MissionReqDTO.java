package com.example.umc9th.domain.mission.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionDTO {
        private LocalDate deadline;
        private Integer point;
        private String condition;
        private Long storeId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateMissionDTO {
        private LocalDate deadline;
        private Integer point;
        private String condition;
    }
}
