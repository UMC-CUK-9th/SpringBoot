package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    public List<UserInfoDto> getUserInfo() {
        return userService.getUserBasicInfo();
    }
}
