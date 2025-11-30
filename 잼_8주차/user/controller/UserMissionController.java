package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserMissionController {
    private final UserCommandService userCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<UserResDto.JoinDTO> signUp(
            @RequestBody @Valid UserReqDto.JoinDTO dto
    ){
        return ApiResponse.success(UserMissionSuccessCode.FOUND, userMissionCommandService.signup(dto));
    }

    private final UserMissionService userMissionService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo() {
        return userMissionService.getUserBasicInfo();
    }
}
