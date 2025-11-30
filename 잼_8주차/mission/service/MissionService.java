package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.domain.mission.dto.MissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionDto> getAvailableMissions(String locationName, Long userId) {
        return missionRepository.findAvailableMissionsByLocation(locationName, userId, PageRequest.of(0, 5));
    }
}