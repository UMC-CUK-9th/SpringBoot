package com.example.umc9th.domain.mission.dto;

import java.time.LocalDateTime;

public class MissionDto {
    private final Long id;
    private final LocalDateTime deadline;
    private final String conditional;
    private final int point;
    private final LocalDateTime createdAt;

    public MissionDto(Long id, LocalDateTime deadline, String conditional, int point, LocalDateTime createdAt) {
        this.id = id;
        this.deadline = deadline;
        this.conditional = conditional;
        this.point = point;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public LocalDateTime getDeadline() { return deadline; }
    public String getConditional() { return conditional; }
    public int getPoint() { return point; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}