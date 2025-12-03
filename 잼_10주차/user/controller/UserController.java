package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.test.converter.TestConverter;
import com.example.umc9th.domain.test.dto.res.TestResDto;
import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.query.UserQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.exception.code.GeneralErrorCode;
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
            @RequestBody @Valid UserReqDto.CreateUser dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND, userCommandService.signup(dto));
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<UserResDto.LoginDTO> login(
            @RequestBody @Valid UserReqDto.LoginDTO dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND, userQueryService.login(dto));
    }


    private final UserService userService;
    private final UserQueryService userQueryService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo() {
        return userService.getUserBasicInfo();
    }

    // 예외 상황
    @GetMapping("/exception")
    public ApiResponse<UserResDto.Exception> exception(
            @RequestParam Long flag
    ) {

        userQueryService.checkFlag(flag);

        // 응답 코드 정의
        GeneralErrorCode code = GeneralErrorCode.NOT_FOUND;
        return ApiResponse.onFailure(code, UserConverter.toExceptionDTO("This is Test!"));
    }
}
