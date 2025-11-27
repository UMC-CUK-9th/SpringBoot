package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.MissionStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionResponse {
    private Long missionId;
    private String missionName;
    private String missionContent;
    private MissionStatus missionStatus;
    private Integer missionPoint;
    private LocalDateTime missionEndDate;
    private String storeName;
    private String regionName;
}
