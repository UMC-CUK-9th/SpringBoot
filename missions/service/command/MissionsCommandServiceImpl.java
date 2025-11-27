package com.example.demo.domain.missions.service.command;

import com.example.demo.domain.missions.converter.MissionsConverter;
import com.example.demo.domain.missions.dto.MissionsReqDto;
import com.example.demo.domain.missions.dto.MissionsResDto;
import com.example.demo.domain.missions.entity.Missions;
import com.example.demo.domain.missions.entity.mapping.MemberMissions;
import com.example.demo.domain.missions.exception.MissionsException;
import com.example.demo.domain.missions.exception.code.MissionsErrorCode;
import com.example.demo.domain.missions.repository.MemberMissionRepository;
import com.example.demo.domain.missions.repository.MissionRepository;
import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.repository.MemberRepository;
import com.example.demo.global.apiPayLoad.exception.GeneralException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionsCommandServiceImpl implements MissionsCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    // 미션 시작
    @Override
    @Transactional
    public MissionsResDto challengeMission(MissionsReqDto request) {

        Members member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(MissionsErrorCode.MEMBER_NOT_FOUND));

        Missions mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionsException(MissionsErrorCode.MISSIONS_NOT_FOUND));

        MemberMissions newChallenge = MissionsConverter.toMemberMission(member, mission);
        memberMissionRepository.save(newChallenge);

        return MissionsResDto.builder()
                .missionInfo(MissionsConverter.toMissionInfoDTO(newChallenge))
                .build();
    }

    // 내가 진행 중인 미션 조회 (페이징)
    @Override
    public MissionsResDto.MissionList findMissionsByUser(Long memberId, int page, int size) {
        Pageable pageable = PageRequest.of(
                page - 1,
                size,
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        Page<MemberMissions> found = memberMissionRepository.findProgressMissionsListByMemberId(memberId, pageable);

        return MissionsConverter.toMissionsListDTO(found.getContent());
    }

}
