package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.restaurant.entity.Restaurant;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
public class MissionConverter {

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
}