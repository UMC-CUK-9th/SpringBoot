package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.validator.ValidPage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/restaurants/{restId}/missions")
public class MissionController implements MissionControllerDocs {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    /**
     * 8주차 미션 - 3. 가게에 미션 추가하기 API
     * POST /
     */
    @PostMapping
    public ApiResponse<MissionResDTO.CreateDTO> createMission(
            @PathVariable Long restId,
            @RequestBody @Valid MissionReqDTO.CreateDTO request
    ) {
        var result = missionCommandService.createMission(restId, request);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }

    /**
     * 9주차 미션 - 2. 특정 가게의 미션 목록 조회하기 API
     * GET /
     */
    @GetMapping
    public ApiResponse<MissionResDTO.MissionPreviewListDTO> getMissions(
            @PathVariable Long restId,
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        var result = missionQueryService.getRestMissions(restId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}