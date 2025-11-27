package com.example.umc9th.domain.restaurant.controller;

import com.example.umc9th.domain.restaurant.dto.req.RestaurantReqDTO;
import com.example.umc9th.domain.restaurant.dto.res.RestaurantResDTO;
import com.example.umc9th.domain.restaurant.service.command.RestaurantCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions/{regionId}/restaurants")
public class RestaurantController implements RestaurantControllerDocs {

    private final RestaurantCommandService restaurantCommandService;

    /**
     * 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
     * POST /
     */
    @PostMapping("")
    public ApiResponse<RestaurantResDTO.CreateRestDTO> createRestaurant(
            @PathVariable("regionId") Long regionId,
            @RequestBody @Valid RestaurantReqDTO.CreateRestDTO dto
    ) {
        RestaurantResDTO.CreateRestDTO response = restaurantCommandService.createInRegion(regionId, dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, response);
    }
}