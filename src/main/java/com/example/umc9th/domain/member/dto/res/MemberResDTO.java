package com.example.umc9th.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {

    // 8주차 예제 - 회원가입 API
    // 10주차 예제 - 1. 간단한 로그인 및 회원가입 구현 (Session 방식)
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createAt
    ){}

    // 10주차 예제 - 2. 간단한 로그인 및 회원가입 구현 (JWT Token 방식)
    @Builder
    public record LoginDTO(
            Long memberId,
            String accessToken
    ){}
}