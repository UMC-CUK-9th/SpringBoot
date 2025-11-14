package com.example.umc9th.domain.usermission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserMissionResponse {
    private String storeName;
    private String missionContent;
    private int missionPoint;
    private String missionStatus;
}
