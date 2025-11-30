package com.example.umc9th.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MissionPageResponse {
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<MissionResponse> missions;
}
