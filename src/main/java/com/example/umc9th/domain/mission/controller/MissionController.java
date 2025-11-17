package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants/{restId}/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ApiResponse<MissionResDTO.CreateDTO> createMission(
            @PathVariable Long restId,
            @RequestBody @Valid MissionReqDTO.CreateDTO request
    ) {
        var result = missionCommandService.createMission(restId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }
}