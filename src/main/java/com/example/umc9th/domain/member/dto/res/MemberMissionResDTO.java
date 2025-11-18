package com.example.umc9th.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
public class MemberMissionResDTO {

    @Builder
    public record CreateDTO(
            Long memberMissionId,
            Long missionId,
            Long memberId,
            String missionStatus,
            LocalDateTime createdAt
    ) {}
}