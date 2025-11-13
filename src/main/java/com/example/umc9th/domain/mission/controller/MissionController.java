package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/missions")
public class MissionController {

    private final MissionQueryService missionQueryService;
    private final MissionCommandService missionCommandService;

    /**
     * 미션 기본 정보 조회
     */
    @GetMapping("/{missionId}")
    public ApiResponse<MissionResDTO.MissionInfoDTO> getMissionInfo(
            @PathVariable Long missionId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                missionQueryService.getMissionInfo(missionId)
        );
    }

    /**
     * 미션 상세 정보 조회
     */
    @GetMapping("/{missionId}/detail")
    public ApiResponse<MissionResDTO.MissionDetailDTO> getMissionDetail(
            @PathVariable Long missionId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                missionQueryService.getMissionDetail(missionId)
        );
    }

    /**
     * 미션 생성
     */
    @PostMapping
    public ApiResponse<MissionResDTO.CreateMissionResultDTO> createMission(
            @RequestBody MissionReqDTO.CreateMissionDTO req
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                missionCommandService.createMission(req)
        );
    }

    /**
     * 미션 정보 수정
     */
    @PutMapping("/{missionId}")
    public ApiResponse<Void> updateMission(
            @PathVariable Long missionId,
            @RequestBody MissionReqDTO.UpdateMissionDTO req
    ) {
        missionCommandService.updateMission(missionId, req);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }

    /**
     * 미션 삭제
     */
    @DeleteMapping("/{missionId}")
    public ApiResponse<Void> deleteMission(
            @PathVariable Long missionId
    ) {
        missionCommandService.deleteMission(missionId);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }
}
