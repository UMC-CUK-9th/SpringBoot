package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.UserReqDTO;
import com.example.umc9th.domain.user.dto.UserResDTO;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.exception.UserSuccessCode;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, user);
    }

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<UserResDTO.JoinDTO> signUp(
            @RequestBody UserReqDTO.JoinDTO dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND,userService.signup(dto));
    }

    @PostMapping("/login")
    public ApiResponse<UserResDTO.LoginDTO> login(
            @RequestBody @Valid UserReqDTO.LoginDTO dto
    ){
        return ApiResponse.success(UserSuccessCode.FOUND,userService.login(dto));
    }
}
