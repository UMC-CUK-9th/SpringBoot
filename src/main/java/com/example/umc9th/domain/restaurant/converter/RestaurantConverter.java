package com.example.umc9th.domain.restaurant.converter;

import com.example.umc9th.domain.restaurant.dto.req.RestaurantReqDTO;
import com.example.umc9th.domain.restaurant.dto.res.RestaurantResDTO;
import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.restaurant.entity.Restaurant;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public class RestaurantConverter {

    // 요청 DTO + Region 엔티티 -> Restaurant 엔티티 생성
    public static Restaurant toEntity(Region region, RestaurantReqDTO.CreateRestDTO dto) {
        return Restaurant.builder()
                .restName(dto.getRestName())
                .address(dto.getAddress())
                .category(dto.getCategory())
                .ownerNumber(dto.getOwnerNumber())
                .region(region)
                .build();
    }

    // Restaurant 엔티티 -> 응답 DTO
    public static RestaurantResDTO.CreateRestDTO toCreateDTO(Restaurant restaurant) {
        return RestaurantResDTO.CreateRestDTO.builder()
                .restId(restaurant.getId())
                .regionId(restaurant.getRegion().getId())
                .regionName(restaurant.getRegion().getRegionName())
                .restName(restaurant.getRestName())
                .address(restaurant.getAddress())
                .category(restaurant.getCategory())
                .ownerNumber(restaurant.getOwnerNumber())
                .createdAt(restaurant.getCreatedAt())
                .build();
    }
}