package com.example.demo.domain.members.service.command;

import com.example.demo.domain.members.converter.MemberConverter;
import com.example.demo.domain.members.dto.MemberReqDto;
import com.example.demo.domain.members.dto.MemberResDto;
import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.entity.Preferences;
import com.example.demo.domain.members.entity.mapping.MemberPreferences;
import com.example.demo.domain.members.exception.code.PreferencesErrorCode;
import com.example.demo.domain.members.repository.MemberPreferencesRepository;
import com.example.demo.domain.members.repository.MemberRepository;
import com.example.demo.domain.members.repository.PreferencesRepository;
import com.example.demo.domain.members.exception.PreferencesException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final MemberPreferencesRepository memberPreferencesRepository;
    private final PreferencesRepository preferencesRepository;

    // 회원가입
    @Override
    @Transactional
    public MemberResDto.JoinDto signup(
            MemberReqDto.JoinDto dto
    ){
        // 사용자 생성
        Members member = MemberConverter.toMember(dto);
        // DB 적용
        memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if (dto.preferCategory() != null && !dto.preferCategory().isEmpty()){

            // Stream을 사용하여 MemberPreferences 리스트를 생성
            List<MemberPreferences> memberPreferencesList = dto.preferCategory().stream()
                    .filter(Objects::nonNull) // null ID 필터링
                    .map(id -> {
                        Preferences preferences = preferencesRepository.findById(id)
                                .orElseThrow(() -> new PreferencesException(PreferencesErrorCode.NOT_FOUND));

                        // MemberPreferences 엔티티 생성 (Converter 사용)
                        return MemberConverter.toMemberPreferences(member, preferences);
                    })
                    .toList(); // Java 16+ Stream toList()

            // 모든 선호 음식 추가: DB 적용
            memberPreferencesRepository.saveAll(memberPreferencesList);
        }

        // 응답 DTO 생성
        return MemberConverter.toJoinDTO(member);
    }
}
