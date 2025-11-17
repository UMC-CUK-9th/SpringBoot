package com.example.demo.domain.missions.converter;

import com.example.demo.domain.missions.dto.MissionsResDto;
import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.members.entity.Members;

public class MissionsConverter {
    public static MemberMissions toMemberMission(Members member, Missions mission) {
        return MemberMissions.builder()
                .members(member)
                .missions(mission)
                .status(false)
                .build();
    }

    public static MissionsResDto toChallengeResponseDTO(MemberMissions memberMission) {
        String statusText = memberMission.getStatus() ? "완료" : "진행 중";

        return MissionsResDto.builder()
                .memberMiId(memberMission.getMemberMiId())
                .missionId(memberMission.getMissions().getMissionId())
                .status(statusText)
                .challengeDate(memberMission.getCreatedAt())
                .build();
    }
}
