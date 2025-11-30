package com.example.umc9th.domain.store.dto.Res;

import lombok.Builder;

import java.time.LocalDateTime;

public class StoreResDto {
    @Builder
    public record JoinDTO(
            Long storeId,
            LocalDateTime createdAt
    ){}
}
