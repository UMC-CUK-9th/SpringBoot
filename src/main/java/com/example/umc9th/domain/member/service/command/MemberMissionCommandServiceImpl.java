package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberMissionRepository;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MissionResDTO.CreateDTO challengeMission(Long memberId, Long missionId, Long restId) {

        // 1) 회원 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(MemberErrorCode.MEMBER_NOT_FOUND));

        // 2) 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(MissionErrorCode.MISSION_NOT_FOUND));

        // 3) 매칭 검증 - 특정 미션이 해당 가게의 미션인지 검증
        if (!mission.getRestaurant().getId().equals(restId)) {
            throw new GeneralException(MissionErrorCode.MISSION_NOT_IN_RESTAURANT);
        }

        // 3) MemberMission 엔티티 생성
        MemberMission memberMission = MemberMissionConverter.toEntity(member, mission);

        // 4) DB 저장
        MemberMission saved = memberMissionRepository.save(memberMission);

        // 5) 응답 DTO 반환
        return MemberMissionConverter.toCreateDTO(saved);
    }
}