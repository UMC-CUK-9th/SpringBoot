package com.example.umc9th.domain.usermission.controller;

import com.example.umc9th.domain.usermission.dto.UserMissionDto;
import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.service.UserMissionService;
import com.example.umc9th.global.annotation.ValidPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.common.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-missions")
@RequiredArgsConstructor
@Tag(name = "User Mission API")
public class UserMissionController {

    private final UserMissionService userMissionService;

    @GetMapping("/completed")
    @Operation(summary = "완료한 미션 목록 조회")
    public ApiResponse<List<UserMissionResponse>> getCompletedMissions(
            @RequestParam Long userId
    ) {
        List<UserMissionResponse> result = userMissionService.getUserMissions(userId);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, result);
    }

    @PostMapping("/{missionId}/challenge")
    @Operation(summary = "미션 도전하기")
    public ApiResponse<Long> challengeMission(@PathVariable Long missionId) {
        Long id = userMissionService.challengeMission(missionId);
        return ApiResponse.success(GeneralSuccessCode.CREATED, id);
    }

    @GetMapping("/in-progress")
    @Operation(summary = "진행중인 미션 목록 조회")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 (page가 1보다 작은 경우)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
    })
    public ApiResponse<PageResponse<UserMissionDto>> getInProgressMissions(
            @RequestParam Long userId,
            @ValidPage @RequestParam Integer page
    ) {
        PageResponse<UserMissionDto> response = userMissionService.getInProgressMissions(userId, page);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, response);
    }
}
