package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.MissionStatus;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
public class MemberMissionConverter {

    // DTO -> Entity
    public static MemberMission toEntity(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
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
}