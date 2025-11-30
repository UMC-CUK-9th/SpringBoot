package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {

    // 8주차 미션 - 3. 가게에 미션 추가하기 API
    @Builder
    public record CreateDTO(
            Long missionId,
            Long restId,
            LocalDateTime deadline,
            LocalDateTime createdAt
    ) {}

    // 9주차 미션 - 2. 특정 가게에 미션 목록 조회하기 API
    @Builder
    public record MissionPreviewDTO(
            Long missionId,
            String content,
            Long price,
            Long point,
            LocalDateTime deadline
    ) {}

    @Builder
    public record MissionPreviewListDTO(
            List<MissionPreviewDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}