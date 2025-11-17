package com.example.demo.domain.missions.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MissionsResDto {
    private Long memberMiId;
    private Integer missionId;
    private String status;
    private LocalDateTime challengeDate;
}