package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.MissionInfoDTO getMissionInfo(Long missionId);
    MissionResDTO.MissionDetailDTO getMissionDetail(Long missionId);

    // 9주차 미션
    MissionResDTO.StoreMissionListDTO getStoreMissions(Long storeId, Integer page);
    MissionResDTO.MyChallengingMissionListDTO getMyChallengingMissions(Long userId, Integer page);
}
