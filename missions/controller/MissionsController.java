package com.example.demo.domain.missions.controller;

import com.example.demo.domain.missions.dto.MissionsReqDto;
import com.example.demo.domain.missions.dto.MissionsResDto;
import com.example.demo.domain.missions.exception.code.MissionsSuccessCode;
import com.example.demo.domain.missions.service.command.MissionsCommandService;
import com.example.demo.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionsController {

    private final MissionsCommandService missionsCommandService;

    // 미션 도전하기
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<MissionsResDto> challengeMission(
            @RequestBody @Valid MissionsReqDto request
    ){
        MissionsResDto result = missionsCommandService.challengeMission(request);
        return ApiResponse.success(MissionsSuccessCode.CREATED, result);
    }
}
