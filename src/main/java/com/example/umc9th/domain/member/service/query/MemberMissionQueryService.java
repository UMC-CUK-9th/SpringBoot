package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;

public interface MemberMissionQueryService {

    // 9주차 미션 - 3. 내가 진행 중인 미션 목록 조회 API
    MemberMissionResDTO.InProgressMissionListDTO getInProgressMissions(Long memberId, Integer page);

    // 9주차 미션 - 4.+ 완료 미션 조회 API
    MemberMissionResDTO.CompletedMissionListDTO getCompletedMissions(Long memberId, Integer page);
}
