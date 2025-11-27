package com.example.umc9th.domain.usermission.converter;

import com.example.umc9th.domain.usermission.dto.UserMissionDto;
import com.example.umc9th.domain.usermission.entity.UserMission;
import com.example.umc9th.global.common.PageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserMissionConverter {

    public static PageResponse<UserMissionDto> toPageResponse(Page<UserMission> page) {
        List<UserMissionDto> userMissionDtoList = page.getContent().stream()
                .map(um -> UserMissionDto.builder()
                        .userMissionId(um.getId())
                        .missionId(um.getMission() != null ? um.getMission().getId() : null)
                        .missionName(um.getMission() != null ? um.getMission().getMissionName() : null)
                        .missionContent(um.getMission() != null ? um.getMission().getMissionContent() : null)
                        .missionPoint(um.getMission() != null ? um.getMission().getMissionPoint() : null)
                        .storeName(um.getMission() != null && um.getMission().getStore() != null 
                                ? um.getMission().getStore().getStoreName() : null)
                        .userMissionStatus(um.getUserMissionStatus())
                        .userMissionStartedAt(um.getUserMissionStartedAt())
                        .missionEndDate(um.getMission() != null ? um.getMission().getMissionEndDate() : null)
                        .regionName(um.getMission() != null && um.getMission().getRegion() != null 
                                ? um.getMission().getRegion().getRegionName() : null)
                        .build())
                .toList();

        return PageResponse.<UserMissionDto>builder()
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .content(userMissionDtoList)
                .build();
    }
}
