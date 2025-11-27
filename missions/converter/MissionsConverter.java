package com.example.demo.domain.missions.converter;

import com.example.demo.domain.missions.dto.MissionsResDto;
import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.members.entity.Members;

import java.util.List;

public class MissionsConverter {

    public static MemberMissions toMemberMission(Members member, Missions mission) {
        return MemberMissions.builder()
                .members(member)
                .missions(mission)
                .status(false)
                .build();
    }

    public static MissionsResDto.missionInfo toMissionInfoDTO(MemberMissions memberMission) {
        String statusText = memberMission.getStatus() ? "완료" : "진행 중";

        return MissionsResDto.missionInfo.builder()
                .memberMiId(memberMission.getMemberMiId())
                .missionId(memberMission.getMissions().getMissionId())
                .status(statusText)
                .challengeDate(memberMission.getCreatedAt())
                .build();
    }

    public static MissionsResDto.MissionList toMissionsListDTO(List<MemberMissions> memberMissionsList) {
        List<MissionsResDto.missionInfo> missionsList = memberMissionsList.stream()
                .map(MissionsConverter::toMissionInfoDTO)
                .toList();

        return MissionsResDto.MissionList.builder()
                .missions(missionsList)
                .build();
    }
}

