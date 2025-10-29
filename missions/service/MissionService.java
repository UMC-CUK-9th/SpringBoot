package com.example.demo.domain.missions.service;

import com.example.demo.domain.missions.entity.mapping.UserMissions;
import com.example.demo.domain.missions.repository.MissionRepository;
import com.example.demo.domain.missions.repository.UsermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;
    private final UsermissionRepository usermissionRepository;

    // 홈화면 미션 조회 (진행 중)
    public Page<UserMissions> getInProgressUserMissions(Long userId, Pageable pageable) {
        return usermissionRepository.findProgressMissionsListByUserId(userId, pageable);
    }

    // 지역별 미션 완료 개수 조회
    public Long countCompletedMissions(Long userId, Long regionId) {
        // Repository에서 완료된 미션 개수를 집계하여 조회
        return missionRepository.countCompletedMissionsInRegion(userId, regionId);
    }

    // 사용자 전체 미션 조회
    public Page<UserMissions> getAllUserMissions(Long userId, Pageable pageable) {
        return usermissionRepository.findAllMissionsListByUserId(userId, pageable);
    }

    // 진행 완료 미션 조회
    public Page<UserMissions> getCompletedUserMissions(Long userId, Pageable pageable) {
        return usermissionRepository.findCompleteMissionsListByUserId(userId, pageable);
    }
}