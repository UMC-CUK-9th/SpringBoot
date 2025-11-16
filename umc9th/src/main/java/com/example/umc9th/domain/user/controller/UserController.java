package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.service.UserService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
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
}
