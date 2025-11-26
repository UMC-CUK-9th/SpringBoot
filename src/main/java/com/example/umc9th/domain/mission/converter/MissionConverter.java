package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import org.springframework.data.domain.Page;

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

    // 9주차 미션 - 특정 가게의 미션 목록 변환 (Stream 사용)
    public static MissionResDTO.StoreMissionListDTO toStoreMissionListDTO(Page<Mission> missionPage) {
        return MissionResDTO.StoreMissionListDTO.builder()
                .missionList(missionPage.getContent().stream()
                        .map(MissionConverter::toStoreMissionDTO)
                        .toList())
                .listSize(missionPage.getSize())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }

    // 9주차 미션 - 특정 가게의 미션 단건 변환
    public static MissionResDTO.StoreMissionDTO toStoreMissionDTO(Mission mission) {
        return MissionResDTO.StoreMissionDTO.builder()
                .missionId(mission.getId())
                .point(mission.getPoint())
                .missionSpec(mission.getCondition())
                .deadline(mission.getDeadline())
                .build();
    }

    // 9주차 미션 - 내가 진행중인 미션 목록 변환 (Stream 사용)
    public static MissionResDTO.MyChallengingMissionListDTO toMyChallengingMissionListDTO(Page<UserMission> userMissionPage) {
        return MissionResDTO.MyChallengingMissionListDTO.builder()
                .missionList(userMissionPage.getContent().stream()
                        .map(MissionConverter::toMyChallengingMissionDTO)
                        .toList())
                .listSize(userMissionPage.getSize())
                .totalPage(userMissionPage.getTotalPages())
                .totalElements(userMissionPage.getTotalElements())
                .isFirst(userMissionPage.isFirst())
                .isLast(userMissionPage.isLast())
                .build();
    }

    // 9주차 미션 - 내가 진행중인 미션 단건 변환
    public static MissionResDTO.MyChallengingMissionDTO toMyChallengingMissionDTO(UserMission userMission) {
        return MissionResDTO.MyChallengingMissionDTO.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getId())
                .storeName(userMission.getMission().getStore().getName())
                .point(userMission.getMission().getPoint())
                .missionSpec(userMission.getMission().getCondition())
                .deadline(userMission.getMission().getDeadline())
                .build();
    }
}
