package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
public interface MissionCommandService {
    MissionResDTO.CreateDTO createMission(Long restId, MissionReqDTO.CreateDTO dto);
}
