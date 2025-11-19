package com.example.umc9th.domain.mission.converter;

public class MissionConverter {
    public static MissionResDto.JoinDTO toJoinDTO(Mission mission) {
        return MissionResDto.JoinDTO.builder()
                .missionId(mission.getId())
                .build();
    }

    // DTO -> Entitiy
    public static Mission toMission(
            MissionReqDto.JoinDTO dto
    ){
        return Mission.builder()
                .build();
    }
}
