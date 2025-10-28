package com.example.umc9th.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionDto {
    private String regionName;
    private Long userPoint;
    private Long completedMissionCount;
    private Long missionId;
    private String storeName;
    private String category;
    private String missionContent;
    private Integer missionPoint;
    private String missionStatus;
    private Long dDay;
}
