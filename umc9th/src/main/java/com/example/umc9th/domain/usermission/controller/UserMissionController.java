package com.example.umc9th.domain.usermission.controller;

import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.service.UserMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-missions")
@RequiredArgsConstructor
public class UserMissionController {

    private final UserMissionService userMissionService;

    @GetMapping("/completed")
    public ApiResponse<List<UserMissionResponse>> getCompletedMissions(
            @RequestParam Long userId
    ) {
        List<UserMissionResponse> result = userMissionService.getUserMissions(userId);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, result);
    }
}
