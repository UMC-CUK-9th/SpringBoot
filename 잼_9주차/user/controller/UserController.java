package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.test.converter.TestConverter;
import com.example.umc9th.domain.test.dto.res.TestResDto;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.query.UserQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.exception.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    //회원가입
    private final UserCommandService userCommandService;

    @PostMapping("/sign-up")
    public ApiResponse<UserResDto.JoinDTO> signUp(
            @RequestBody @Valid UserReqDto.JoinDTO dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND, userCommandService.signup(dto));
    }


    private final UserService userService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo() {
        return userService.getUserBasicInfo();
    }

    // 예외 상황
    @GetMapping("/exception")
    public ApiResponse<UserResDto.Exception> exception(
            @RequestParam Long flag
    ) {

        UserQueryService.checkFlag(flag);

        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.success(code, TestConverter.toExceptionDTO("This is Test!"));
    }
}
