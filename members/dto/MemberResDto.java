package com.example.demo.domain.members.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDto {
    @Builder
    public static class JoinDto {
        Long userId;
        LocalDateTime createdAt;
    }
}
