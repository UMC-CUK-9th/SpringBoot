package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Member API", description = "회원 관련 API")
@Validated
public interface MemberControllerDocs {

    @Operation(
            summary = "회원가입 API By 노바 (개발 완료)",
            description = "이메일, 비밀번호, 닉네임 등의 정보로 회원을 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "회원가입 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값")
    })
    @PostMapping("/members")
    ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody(description = "회원가입 요청 바디", required = true)
            @Valid MemberReqDTO.JoinDTO dto
    );
}