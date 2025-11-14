package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<MissionDto> getMissionsByRegion(Long userId, Long regionId, Long lastMissionId) {
        return missionRepository.findMissionsByRegion(
                userId,
                regionId,
                lastMissionId,
                UserMissionStatus.COMPLETE
        );
    }

    public ApiResponse<List<MissionDto>> getMissionsByRegionResponse(Long userId, Long regionId, Long lastMissionId) {
        List<MissionDto> missions = getMissionsByRegion(userId, regionId, lastMissionId);
        return ApiResponse.success(GeneralSuccessCode.SUCCESS, missions);
    }
}
