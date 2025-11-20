package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;

public class MissionConverter {

    // Mission Entity -> 기본 정보 DTO 변환
    public static MissionResDTO.MissionInfoDTO toMissionInfoDTO(Mission mission) {
        return MissionResDTO.MissionInfoDTO.builder()
                .id(mission.getId())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .condition(mission.getCondition())
                .storeId(mission.getStore().getId())
                .build();
    }

    // Mission Entity -> 상세 정보 DTO 변환
    public static MissionResDTO.MissionDetailDTO toMissionDetailDTO(Mission mission) {
        return MissionResDTO.MissionDetailDTO.builder()
                .id(mission.getId())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .condition(mission.getCondition())
                .storeId(mission.getStore().getId())
                .storeName(mission.getStore().getName())
                .build();
    }

    // Mission Entity -> 생성 결과 DTO 변환
    public static MissionResDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .point(mission.getPoint())
                .build();
    }

    // 8주차 과제: 미션 도전하기 API - UserMission Entity -> 미션 도전 결과 DTO 변환
    public static MissionResDTO.ChallengeMissionResultDTO toChallengeMissionResultDTO(
            UserMission userMission) {
        return MissionResDTO.ChallengeMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getId())
                .storeName(userMission.getMission().getStore().getName())
                .point(userMission.getMission().getPoint())
                .status(userMission.getStatus().toString())
                .build();
    }
}
