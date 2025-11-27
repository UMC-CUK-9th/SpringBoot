package com.example.umc9th.domain.member.controller;


import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.member.service.command.MemberMissionCommandService;
import com.example.umc9th.domain.member.service.query.MemberMissionQueryService;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.validator.ValidPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class MemberMissionController implements MemberMissionControllerDocs {

    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    /**
     * 8주차 미션 - 4. 가게의 미션을 도전 중인 미션에 추가하기(미션 도전하기) API
     * POST /
     */
    @PostMapping("/restaurants/{restId}/missions/{missionId}/challenge")
    public ApiResponse<MissionResDTO.CreateDTO> challengeMission(
            @PathVariable Long restId,
            @PathVariable Long missionId,
            @RequestParam("memberId") Long memberId
    ) {
        var result = memberMissionCommandService.challengeMission(memberId, missionId, restId);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }

    /**
     * 9주차 미션 - 3. 내가 진행 중인 미션 목록 조회하기 API
     * GET /
     */
    @GetMapping("/members/{memberId}/missions/in-progress")
    public ApiResponse<MemberMissionResDTO.InProgressMissionListDTO> getInProgressMissions(
            @PathVariable Long memberId,
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        var result = memberMissionQueryService.getInProgressMissions(memberId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    /**
     * 9주차 미션 - 4. 진행중인 미션 진행 완료로 바꾸기 API
     * POST /
     */
    @PostMapping("/members/{memberId}/missions/{memberMissionId}/complete")
    public ApiResponse<MemberMissionResDTO.CompletedMissionDTO> completeMission(
            @PathVariable Long memberId,
            @PathVariable Long memberMissionId
    ) {
        var result = memberMissionCommandService.completeMission(memberId, memberMissionId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    /**
     * 9주차 미션 - 4.+ 완료 미션 조회하기 API
     * GET /
     */
    @GetMapping("/members/{memberId}/missions/completed")
    public ApiResponse<MemberMissionResDTO.CompletedMissionListDTO> getCompletedMissions(
            @PathVariable Long memberId,
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        var result = memberMissionQueryService.getCompletedMissions(memberId, page);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}