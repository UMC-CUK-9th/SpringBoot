package com.example.umc9th.domain.store.dto;

import java.time.LocalDateTime;

public class StoreDto {
    private final Long id;
    private final LocalDateTime createdAt;

    public StoreDto(Long id, LocalDateTime deadline, String conditional, int point, LocalDateTime createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}