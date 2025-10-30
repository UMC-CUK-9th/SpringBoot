package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("/available")
    public List<MissionDto> getAvailableMissions(
            @RequestParam String locationName,
            @RequestParam Long userId
    ) {
        return missionService.getAvailableMissions(locationName, userId);
    }
}