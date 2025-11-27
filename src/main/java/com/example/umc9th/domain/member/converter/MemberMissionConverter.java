package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.MissionStatus;
import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MemberMissionConverter {

    // 8주차 미션 - 4. 가게의 미션을 도전 중인 미션에 추가하기(미션 도전하기) API
    // DTO -> Entity
    public static MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .restaurant(mission.getRestaurant())
                .missionStatus(MissionStatus.IN_PROGRESS) // 기본값: 진행중
                .build();
    }

    // Entity -> DTO
    public static MissionResDTO.CreateDTO toCreateDTO(MemberMission memberMission) {
        return MissionResDTO.CreateDTO.builder()
                .missionId(memberMission.getMission().getId())  // 미션 ID
                .restId(memberMission.getMission().getRestaurant().getId()) // 가게 ID
                .deadline(memberMission.getMission().getDeadline())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }

    // 9주차 미션 - 3. 내가 진행 중인 미션 목록 조회하기 API
    public static MemberMissionResDTO.InProgressMissionDTO toInProgressMissionDTO(MemberMission memberMission) {
        return MemberMissionResDTO.InProgressMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .restId(memberMission.getMission().getRestaurant().getId())
                .restName(memberMission.getMission().getRestaurant().getRestName())
                .content(memberMission.getMission().getContent())
                .price(memberMission.getMission().getPrice())
                .point(memberMission.getMission().getPoint())
                .deadline(memberMission.getMission().getDeadline())
                .status(memberMission.getMissionStatus().name())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberMissionResDTO.InProgressMissionListDTO toInProgressMissionListDTO(Page<MemberMission> memberMissions) {
        return MemberMissionResDTO.InProgressMissionListDTO.builder()
                .missionList(memberMissions.stream()
                        .map(MemberMissionConverter::toInProgressMissionDTO)
                        .toList())
                .listSize(memberMissions.getNumberOfElements())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .isFirst(memberMissions.isFirst())
                .isLast(memberMissions.isLast())
                .build();
    }

    // 9주차 미션 - 4. 진행중인 미션 진행 완료로 바꾸기 API
    public static MemberMissionResDTO.CompletedMissionDTO toCompletedMissionDTO(MemberMission memberMission) {
        return MemberMissionResDTO.CompletedMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .restId(memberMission.getMission().getRestaurant().getId())
                .restName(memberMission.getMission().getRestaurant().getRestName())
                .content(memberMission.getMission().getContent())
                .price(memberMission.getMission().getPrice())
                .point(memberMission.getMission().getPoint())
                .deadline(memberMission.getMission().getDeadline())
                .status(memberMission.getMissionStatus().name())
                .updatedAt(memberMission.getUpdatedAt())
                .build();
    }

    public static MemberMissionResDTO.CompletedMissionListDTO toCompletedMissionListDTO(Page<MemberMission> memberMissions) {
        return MemberMissionResDTO.CompletedMissionListDTO.builder()
                .missionList(memberMissions.stream()
                        .map(MemberMissionConverter::toCompletedMissionDTO)
                        .toList())
                .listSize(memberMissions.getNumberOfElements())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .isFirst(memberMissions.isFirst())
                .isLast(memberMissions.isLast())
                .build();
    }
}