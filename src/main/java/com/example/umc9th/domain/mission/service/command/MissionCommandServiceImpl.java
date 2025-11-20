package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.user.exception.UserException;
import com.example.umc9th.domain.user.exception.code.UserErrorCode;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;

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

    // 8주차 과제: 미션 도전하기 API
    @Override
    public MissionResDTO.ChallengeMissionResultDTO challengeMission(Long storeId, Long missionId) {
        // Store 존재 여부 확인
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        // Mission 존재 여부 확인 및 해당 Store의 Mission인지 검증
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.MISSION_NOT_FOUND));

        if (!mission.getStore().getId().equals(storeId)) {
            throw new MissionException(MissionErrorCode.MISSION_STORE_NOT_MATCH);
        }

        // 하드코딩된 User ID (DB에 있는 첫 번째 사용자 사용)
        User user = userRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 이미 도전 중인 미션인지 확인
        if (userMissionRepository.existsByUserIdAndMissionId(user.getId(), missionId)) {
            throw new MissionException(MissionErrorCode.ALREADY_CHALLENGING_MISSION);
        }

        // UserMission 생성 및 저장
        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        UserMission savedUserMission = userMissionRepository.save(userMission);

        return MissionConverter.toChallengeMissionResultDTO(savedUserMission);
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
