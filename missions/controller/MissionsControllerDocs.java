package com.example.demo.domain.missions.controller;

import com.example.demo.domain.missions.dto.MissionsResDto;
import com.example.demo.global.apiPayLoad.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface MissionsControllerDocs {
    @Operation(summary = "내가 진행 중인 미션 목록",
            description = "사용자가 진행 중인 미션 목록을 페이지 단위로 반환합니다. page는 1부터 시작합니다.")
    @GetMapping("/my/{memberId}/in-progress")
    ApiResponse<MissionsResDto.MissionList> myMissions(
            @Parameter(description = "페이지 번호 (1 이상)", required = true)
            @RequestParam(defaultValue = "1") int page,

            @Parameter(description = "페이지 크기", required = false)
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "사용자 아이디", required = true)
            @RequestParam Long memberId
    );
}
