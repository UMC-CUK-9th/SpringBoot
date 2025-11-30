package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;

public class MissionConverter {

    // 8주차 미션 - 3. 가게에 미션 추가하기 API
    // DTO -> Entity
    public static Mission toEntity(Restaurant restaurant, MissionReqDTO.CreateDTO dto) {
        return Mission.builder()
                .restaurant(restaurant)
                .content(dto.getContent())
                .deadline(dto.getDeadline())
                .price(dto.getPrice())
                .point(dto.getPoint())
                .build();
    }

    // Entity -> DTO
    public static MissionResDTO.CreateDTO toCreateDTO(Mission mission) {
        return MissionResDTO.CreateDTO.builder()
                .missionId(mission.getId())
                .restId(mission.getRestaurant().getId())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    // 9주차 미션 - 2. 특정 가게에 미션 목록 조회 API
    // 특정 가게의 미션 목록 조회용 변환 (Stream 사용)
    public static MissionResDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<Mission> missions) {
        return MissionResDTO.MissionPreviewListDTO.builder()
                .missionList(
                        missions.getContent().stream()
                                .map(MissionConverter::toMissionPreviewDTO)
                                .toList()
                )
                .listSize(missions.getSize())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    public static MissionResDTO.MissionPreviewDTO toMissionPreviewDTO(Mission mission) {
        return MissionResDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .price(mission.getPrice())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }
}