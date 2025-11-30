package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionQueryService {

    // 9주차 미션 - 2. 특정 가게에 미션 목록 조회하기 API
    MissionResDTO.MissionPreviewListDTO getRestMissions(Long restId, Integer page);
}