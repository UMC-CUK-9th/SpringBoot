package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.MissionErrorCode;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.common.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

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

    public PageResponse<MissionDto> getMissionsByStore(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.STORE_NOT_FOUND));
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Mission> missionPage = missionRepository.findAllByStore(store, pageRequest);
        return MissionConverter.toPageResponse(missionPage);
    }
}
