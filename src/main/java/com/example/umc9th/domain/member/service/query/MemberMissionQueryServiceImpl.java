package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.converter.MemberMissionConverter;
import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.member.enums.MissionStatus;
import com.example.umc9th.domain.member.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private static final int PAGE_SIZE = 10;
    private final MemberMissionRepository memberMissionRepository;

    // 9주차 미션 - 3. 내가 진행 중인 미션 목록 조회 API
    @Override
    @Transactional(readOnly = true)
    public MemberMissionResDTO.InProgressMissionListDTO getInProgressMissions(Long memberId, Integer page) {
        var pageRequest = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "updatedAt"));
        var missions = memberMissionRepository.findAllByMemberIdAndMissionStatus(
                memberId,
                MissionStatus.IN_PROGRESS,
                pageRequest
        );
        return MemberMissionConverter.toInProgressMissionListDTO(missions);
    }

    // 9주차 미션 - 4.+ 완료 미션 조회하기 API
    @Override
    @Transactional(readOnly = true)
    public MemberMissionResDTO.CompletedMissionListDTO getCompletedMissions(Long memberId, Integer page) {
        var pageRequest = PageRequest.of(page - 1, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "updatedAt"));
        var missions = memberMissionRepository.findAllByMemberIdAndMissionStatus(
                memberId,
                MissionStatus.COMPLETED,
                pageRequest
        );
        return MemberMissionConverter.toCompletedMissionListDTO(missions);
    }
}
