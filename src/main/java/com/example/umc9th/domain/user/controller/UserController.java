package com.example.umc9th.domain.user.controller;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.exception.code.UserSuccessCode;
import com.example.umc9th.domain.user.service.command.UserCommandService;
import com.example.umc9th.domain.user.service.query.UserQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    // 회원가입
    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/sign-up")
    public ApiResponse<UserResDTO.JoinDTO> signUp(
            @RequestBody @Valid UserReqDTO.JoinDTO dto
    ){
        return ApiResponse.onSuccess(
                UserSuccessCode.FOUND,
                userCommandService.signup(dto)
        );
    }

    // 로그인
    @Operation(summary = "로그인", description = "이메일과 비밀번호로 로그인합니다.")
    @PostMapping("/login")
    public ApiResponse<UserResDTO.LoginDTO> login(
            @RequestBody @Valid UserReqDTO.LoginDTO dto
    ){
        return ApiResponse.onSuccess(UserSuccessCode.FOUND, userQueryService.login(dto));
    }

    // 로그아웃 (Swagger 문서화용 - 실제 처리는 Spring Security가 담당)
    @Operation(summary = "로그아웃", description = "세션을 무효화하고 로그아웃합니다. (세션 방식)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "로그아웃 성공")
    })
    @PostMapping("/logout")
    public void logout() {
        // Spring Security의 LogoutFilter가 처리하므로 이 메서드는 실행되지 않음
    }
}
