package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.dto.MissionPageResponse;
import com.example.umc9th.domain.mission.dto.MissionResponse;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.global.common.PageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class MissionConverter {

    public static MissionPageResponse toMissionPageResponse(Page<Mission> page) {

        List<MissionResponse> list = page.getContent().stream()
                .map(m -> MissionResponse.builder()
                        .missionId(m.getId())
                        .missionName(m.getMissionName())
                        .missionContent(m.getMissionContent())
                        .missionStatus(m.getMissionStatus())
                        .missionPoint(m.getMissionPoint())
                        .missionEndDate(m.getMissionEndDate())
                        .storeName(m.getStore() != null ? m.getStore().getStoreName() : null)
                        .regionName(m.getRegion() != null ? m.getRegion().getRegionName() : null)
                        .build())
                .toList();

        return MissionPageResponse.builder()
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .missions(list)
                .build();
    }

    public static PageResponse<MissionDto> toPageResponse(Page<Mission> page) {
        List<MissionDto> missionDtoList = page.getContent().stream()
                .map(m -> MissionDto.builder()
                        .missionId(m.getId())
                        .missionName(m.getMissionName())
                        .missionContent(m.getMissionContent())
                        .missionStatus(m.getMissionStatus())
                        .missionPoint(m.getMissionPoint())
                        .missionEndDate(m.getMissionEndDate())
                        .storeName(m.getStore() != null ? m.getStore().getStoreName() : null)
                        .regionName(m.getRegion() != null ? m.getRegion().getRegionName() : null)
                        .build())
                .toList();

        return PageResponse.<MissionDto>builder()
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .content(missionDtoList)
                .build();
    }
}
