package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/region")
    public ApiResponse<List<MissionDto>> getMissionsByRegion(
            @RequestParam Long userId,
            @RequestParam Long regionId,
            @RequestParam Long lastMissionId
    ) {
        return missionService.getMissionsByRegionResponse(userId, regionId, lastMissionId);
    }
}
