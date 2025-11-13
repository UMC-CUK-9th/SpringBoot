package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public MissionResDTO.CreateMissionResultDTO createMission(MissionReqDTO.CreateMissionDTO req) {
        // 유효성 검사
        if (req.getDeadline() == null || req.getDeadline().isBefore(LocalDate.now())) {
            throw new MissionException(MissionErrorCode.INVALID_MISSION_DEADLINE);
        }

        if (req.getPoint() == null || req.getPoint() < 0) {
            throw new MissionException(MissionErrorCode.INVALID_MISSION_POINT);
        }

        // Store 존재 여부 확인
        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_STORE_NOT_FOUND));

        // Mission Entity 생성 및 저장
        Mission mission = Mission.builder()
                .deadline(req.getDeadline())
                .point(req.getPoint())
                .condition(req.getCondition())
                .store(store)
                .build();

        Mission savedMission = missionRepository.save(mission);

        return MissionConverter.toCreateMissionResultDTO(savedMission);
    }

    @Override
    public void updateMission(Long missionId, MissionReqDTO.UpdateMissionDTO req) {
        // 미션 존재 여부 검증
        missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        // 유효성 검사
        if (req.getDeadline() != null && req.getDeadline().isBefore(LocalDate.now())) {
            throw new MissionException(MissionErrorCode.INVALID_MISSION_DEADLINE);
        }

        if (req.getPoint() != null && req.getPoint() < 0) {
            throw new MissionException(MissionErrorCode.INVALID_MISSION_POINT);
        }

        // Mission Entity 업데이트 (필요에 따라 업데이트 메서드 추가)
    }

    @Override
    public void deleteMission(Long missionId) {
        // 미션 존재 여부 검증
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        // Mission Entity 삭제
        missionRepository.delete(mission);
    }
}
