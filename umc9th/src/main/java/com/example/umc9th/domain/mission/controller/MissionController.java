package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.annotation.ValidPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.common.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
@Tag(name = "Mission API")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/region")
    @Operation(summary = "지역별 미션 조회", description = "특정 지역의 미션 목록을 조회합니다.")
    public ApiResponse<?> getMissionsByRegion(
            @RequestParam Long userId,
            @RequestParam Long regionId,
            @RequestParam Long lastMissionId
    ) {
        return missionService.getMissionsByRegionResponse(userId, regionId, lastMissionId);
    }

    @GetMapping("/store/{storeId}")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 (page가 1보다 작은 경우)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음")
    })
    public ApiResponse<PageResponse<MissionDto>> getMissionsByStore(
            @PathVariable Long storeId,
            @ValidPage @RequestParam Integer page
    ) {
        PageResponse<MissionDto> response = missionService.getMissionsByStore(storeId, page);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, response);
    }
}
