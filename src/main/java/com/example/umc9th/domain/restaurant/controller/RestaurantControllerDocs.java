package com.example.umc9th.domain.restaurant.controller;

import com.example.umc9th.domain.restaurant.dto.req.RestaurantReqDTO;
import com.example.umc9th.domain.restaurant.dto.res.RestaurantResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Restaurant API", description = "가게 관련 API")
@Validated
@RequestMapping("/regions/{regionId}/restaurants")
public interface RestaurantControllerDocs {

    @Operation(
            summary = "특정 지역에 가게 등록 API By 노바 (개발 완료)",
            description = "특정 지역(regionId)에 새로운 가게를 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "가게 등록 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "지역을 찾을 수 없음")
    })
    @PostMapping("")
    ApiResponse<RestaurantResDTO.CreateRestDTO> createRestaurant(
            @Parameter(description = "가게를 생성할 지역 ID", example = "1")
            @PathVariable("regionId") Long regionId,
            @RequestBody(description = "가게 생성 요청 바디", required = true)
            @Valid RestaurantReqDTO.CreateRestDTO dto
    );
}