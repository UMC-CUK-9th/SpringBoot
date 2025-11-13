package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.query.UserQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    /**
     * 사용자 기본 정보 조회
     */
    @GetMapping("/{userId}")
    public ApiResponse<UserResDTO.UserInfoDTO> getUserInfo(
            @PathVariable Long userId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                userQueryService.getUserInfo(userId)
        );
    }

    /**
     * 사용자 상세 정보 조회
     */
    @GetMapping("/{userId}/detail")
    public ApiResponse<UserResDTO.UserDetailDTO> getUserDetail(
            @PathVariable Long userId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                userQueryService.getUserDetail(userId)
        );
    }

    /**
     * 사용자 생성
     */
    @PostMapping
    public ApiResponse<UserResDTO.CreateUserResultDTO> createUser(
            @RequestBody UserReqDTO.CreateUserDTO req
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                userCommandService.createUser(req)
        );
    }

    /**
     * 사용자 정보 수정
     */
    @PutMapping("/{userId}")
    public ApiResponse<Void> updateUser(
            @PathVariable Long userId,
            @RequestBody UserReqDTO.UpdateUserDTO req
    ) {
        userCommandService.updateUser(userId, req);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }

    /**
     * 사용자 삭제
     */
    @DeleteMapping("/{userId}")
    public ApiResponse<Void> deleteUser(
            @PathVariable Long userId
    ) {
        userCommandService.deleteUser(userId);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }
}
