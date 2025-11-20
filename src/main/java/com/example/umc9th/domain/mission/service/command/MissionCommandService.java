package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.CreateMissionResultDTO createMission(MissionReqDTO.CreateMissionDTO req);
    // 8주차 과제: 미션 도전하기 API
    MissionResDTO.ChallengeMissionResultDTO challengeMission(Long storeId, Long missionId);
    void updateMission(Long missionId, MissionReqDTO.UpdateMissionDTO req);
    void deleteMission(Long missionId);
}
