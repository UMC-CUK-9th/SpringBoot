package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
public interface MemberMissionCommandService {
    MissionResDTO.CreateDTO challengeMission(Long memberId, Long missionId, Long restId);
}
