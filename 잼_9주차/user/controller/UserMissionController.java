package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.review.controller.ValidPage;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserMissionResDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.exception.code.UserMissionSuccessCode;
import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.command.UserMissionCommandService;
import com.example.umc9th.domain.user.service.command.UserMissionCommandServiceImpl;
import com.example.umc9th.global.apiPayload.ApiResponse;
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
    public ApiResponse<UserResDto.CreateUser> signUp(
            @RequestBody @Valid UserReqDto.CreateUser dto
    ){
        return ApiResponse.success(UserMissionSuccessCode.FOUND, userMissionCommandService.signup(dto));
    }

    private final UserMissionCommandServiceImpl userMissionService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo() {
        return userMissionService.getUserBasicInfo();
    }

//    validPage 적용
    @GetMapping("/{userId}/missions/in-progress")
    public Page<UserMissionResDto> getMyMissionList(
            @PathVariable Long userId,
            @ValidPage Integer page
    ) {
        return userMissionService.getMyMissions(userId, page);
    }
}
