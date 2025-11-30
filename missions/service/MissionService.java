package com.example.demo.domain.missions.service;

import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.missions.repository.MemberMissionRepository;
import com.example.demo.domain.missions.repository.MissionRepository;
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
    private final MemberMissionRepository membermissionRepository;

    // 홈화면 미션 조회 (진행 중)
    public Page<MemberMissions> getInProgressUserMissions(Long memberId, Pageable pageable) {
        return membermissionRepository.findProgressMissionsListByMemberId(memberId, pageable);
    }

    // 지역별 미션 완료 개수 조회
    public Long countCompletedMissions(Long memberId, Long regionId) {
        // Repository에서 완료된 미션 개수를 집계하여 조회
        return missionRepository.countCompletedMissionsInRegion(memberId, regionId);
    }

    // 사용자 전체 미션 조회
    public Page<MemberMissions> getAllUserMissions(Long memberId, Pageable pageable) {
        return membermissionRepository.findAllMissionsListByUserId(memberId, pageable);
    }

    // 진행 완료 미션 조회
    public Page<MemberMissions> getCompletedUserMissions(Long memberId, Pageable pageable) {
        return membermissionRepository.findCompleteMissionsListByUserId(memberId, pageable);
    }
}