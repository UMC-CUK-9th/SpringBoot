package com.example.umc9th.domain.restaurant.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public class RestaurantResDTO {

    @Getter
    @Builder
    @Schema(name = "RestaurantCreateResponse")
    public static class CreateRestDTO {
        private Long restId;
        private Long regionId;
        private String restName;
        private String regionName;
        private String address;
        private String category;
        private String ownerNumber;
        private LocalDateTime createdAt;
    }
}