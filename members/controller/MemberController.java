package com.example.demo.domain.members.controller;

import com.example.demo.domain.members.dto.MemberReqDto;
import com.example.demo.domain.members.dto.MemberResDto;
import com.example.demo.domain.members.exception.code.MemberSuccessCode;
import com.example.demo.domain.members.service.command.MemberCommandService;
import com.example.demo.global.apiPayLoad.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@ResponseStatus(HttpStatus.CREATED)
public class MemberController {

    private final MemberCommandService memberCommandService;

    // 회원가입
    @PostMapping
    public ApiResponse<MemberResDto.JoinDto> signUp(
            @RequestBody @Valid MemberReqDto.JoinDto dto
    ){
        MemberResDto.JoinDto result = memberCommandService.signup(dto);
        return ApiResponse.success(MemberSuccessCode.CREATED, result);
    }
}