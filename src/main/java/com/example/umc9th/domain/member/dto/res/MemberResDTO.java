package com.example.umc9th.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {

    // 8주차 예제 - 회원가입 API
    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createAt
    ){}
}