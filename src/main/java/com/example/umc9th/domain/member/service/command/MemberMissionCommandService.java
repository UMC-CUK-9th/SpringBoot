package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;

public interface MemberMissionCommandService {

    // 8주차 미션 - 4. 가게의 미션을 도전 중인 미션에 추가하기(미션 도전하기) API
    MissionResDTO.CreateDTO challengeMission(Long memberId, Long missionId, Long restId);

    // 9주차 미션 - 4. 진행중인 미션 진행 완료로 바꾸기 API
    MemberMissionResDTO.CompletedMissionDTO completeMission(Long memberId, Long memberMissionId);
}