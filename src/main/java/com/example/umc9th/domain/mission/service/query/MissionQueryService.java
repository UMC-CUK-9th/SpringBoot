package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.MissionInfoDTO getMissionInfo(Long missionId);
    MissionResDTO.MissionDetailDTO getMissionDetail(Long missionId);
}
