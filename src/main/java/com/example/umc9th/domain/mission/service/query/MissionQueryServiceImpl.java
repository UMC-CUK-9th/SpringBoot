package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public MissionResDTO.MissionInfoDTO getMissionInfo(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        return MissionConverter.toMissionInfoDTO(mission);
    }

    @Override
    public MissionResDTO.MissionDetailDTO getMissionDetail(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        return MissionConverter.toMissionDetailDTO(mission);
    }

    // 9주차 미션 - 특정 가게의 미션 목록 조회
    @Override
    public MissionResDTO.StoreMissionListDTO getStoreMissions(Long storeId, Integer page) {
        // 페이지 번호는 0부터 시작하므로 1을 빼줌 (프론트엔드는 1부터 전달)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Mission> missionPage = missionRepository.findAllByStoreId(storeId, pageRequest);

        return MissionConverter.toStoreMissionListDTO(missionPage);
    }

    // 9주차 미션 - 내가 진행중인 미션 목록 조회
    @Override
    public MissionResDTO.MyChallengingMissionListDTO getMyChallengingMissions(Long userId, Integer page) {
        // 페이지 번호는 0부터 시작하므로 1을 빼줌 (프론트엔드는 1부터 전달)
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<UserMission> userMissionPage = userMissionRepository.findChallengingMissionsByUserId(userId, pageRequest);

        return MissionConverter.toMyChallengingMissionListDTO(userMissionPage);
    }
}
