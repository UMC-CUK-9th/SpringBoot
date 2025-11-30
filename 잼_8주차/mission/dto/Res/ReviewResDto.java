package com.example.umc9th.domain.mission.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDto {
    @Builder
    public record JoinDTO(
            Long id,
            Integer point,
            String conditional,
            LocalDateTime deadline,
            LocalDateTime createdAt
    ){}
}
