package com.example.umc9th.domain.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class UserResDTO {
    @Builder
    public record JoinDTO(
            Long userId,
            LocalDateTime createAt
    ){}

    @Builder
    public record LoginDTO(
            Long userId,
            String accessToken
    ){}
}
