package com.example.umc9th.domain.usermission.dto;

import com.example.umc9th.domain.mission.entity.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMissionResponse {
    private String storeName;
    private String missionContent;
    private int missionPoint;
    private MissionStatus missionStatus;
}
