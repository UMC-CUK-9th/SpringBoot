package com.example.umc9th.domain.restaurant.service.command;

import com.example.umc9th.domain.restaurant.dto.req.RestaurantReqDTO;
import com.example.umc9th.domain.restaurant.dto.res.RestaurantResDTO;
import org.springframework.transaction.annotation.Transactional;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public interface RestaurantCommandService {

    RestaurantResDTO.CreateRestDTO createInRegion(
            Long regionId, RestaurantReqDTO.CreateRestDTO dto);
}