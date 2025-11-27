package com.example.umc9th.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResDTO {

    // 8주차 미션 - 4. 가게의 미션을 도전 중인 미션에 추가하기(미션 도전하기) API
    @Builder
    public record CreateDTO(
            Long memberMissionId,
            Long missionId,
            Long memberId,
            String missionStatus,
            LocalDateTime createdAt
    ) {}

    // 9주차 미션 - 3. 내가 진행 중인 미션 목록 조회하기 API
    @Builder
    public record InProgressMissionDTO(
            Long memberMissionId,
            Long missionId,
            Long restId,
            String restName,
            String content,
            Long price,
            Long point,
            LocalDateTime deadline,
            String status,
            LocalDateTime updatedAt
    ) {}

    @Builder
    public record InProgressMissionListDTO(
            List<InProgressMissionDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    // 9주차 미션 - 4. 진행중인 미션 진행 완료로 바꾸기 API
    @Builder
    public record CompletedMissionDTO(
            Long memberMissionId,
            Long missionId,
            Long restId,
            String restName,
            String content,
            Long price,
            Long point,
            LocalDateTime deadline,
            String status,
            LocalDateTime updatedAt
    ) {}

    @Builder
    public record CompletedMissionListDTO(
            List<CompletedMissionDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}