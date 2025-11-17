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
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionsCommandServiceImpl implements MissionsCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MissionsResDto challengeMission(MissionsReqDto request) {

        // Members와 Missions 엔티티 조회 및 존재 여부 검증
        Members member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(MissionsErrorCode.MEMBER_NOT_FOUND));

        Missions mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionsException(MissionsErrorCode.MISSIONS_NOT_FOUND));

        MemberMissions newChallenge = MissionsConverter.toMemberMission(member, mission);

        // DB에 저장
        memberMissionRepository.save(newChallenge);

        return MissionsConverter.toChallengeResponseDTO(newChallenge);
    }
}
