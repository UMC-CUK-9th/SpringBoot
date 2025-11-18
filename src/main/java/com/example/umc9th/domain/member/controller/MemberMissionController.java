package com.example.umc9th.domain.member.controller;


import com.example.umc9th.domain.member.service.command.MemberMissionCommandService;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
@RestController
@RequiredArgsConstructor
@RequestMapping("/members/{memberId}/missions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResDTO.CreateDTO> challengeMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId,
            @PathVariable Long restId
    ) {
        var result = memberMissionCommandService.challengeMission(memberId, missionId, restId);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, result);
    }
}