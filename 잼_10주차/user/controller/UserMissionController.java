package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.command.UserMissionCommandService;
import com.example.umc9th.global.annotation.ValidPage;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserMissionResDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.exception.code.UserMissionSuccessCode;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.command.UserMissionCommandServiceImpl;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.exception.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserMissionController {
    private final UserCommandService userCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<UserResDto.JoinDTO> signUp(
            @RequestBody @Valid UserReqDto.CreateUser dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND, userCommandService.signup(dto));
    }

    private final UserMissionCommandServiceImpl userMissionService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo(@RequestParam Long userId) {
        return userMissionService.getUserBasicInfo(userId);
    }

//    validPage 적용
    @GetMapping("/{userId}/missions/in-progress")
    public Page<UserMissionResDto.CreateDTO> getMyMissionList(
            @PathVariable Long userId,
            @ValidPage Integer page
    ) {
        return userMissionService.getMyMissions(userId,page);
    }

    @PostMapping("/{userId}/missions/create")
    public ApiResponse<Void> createMission(
            @PathVariable Long userId, Long missionId, Long storeId
    ){
        userMissionService.mission(userId,missionId,storeId);
        return ApiResponse.success(GeneralSuccessCode.OK, null);
    }
}
