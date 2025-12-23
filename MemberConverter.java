package com.example.demo.domain.members.converter;

import com.example.demo.domain.members.dto.MemberReqDto;
import com.example.demo.domain.members.dto.MemberResDto;
import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.entity.Preferences;
import com.example.demo.domain.members.entity.mapping.MemberPreferences;
import com.example.demo.domain.members.enums.Role;


public class MemberConverter {

    public static Members toMember(
            MemberReqDto.JoinDto dto,
            String password, // 해시된 비밀번호 수신
            Role role        // 기본 권한 수신
    ){
        return Members.builder()
                .name(dto.name())
                .nickname(dto.nickname())
                .email(dto.email())
                .password(password)
                .role(role)
                .birth(dto.birth())
                .address(dto.address())
                .gender(dto.gender())
                .logType(dto.logType())
                .point(dto.point())
                .build();
    }

    public static MemberResDto.JoinDto toJoinDTO(Members member) {
        return MemberResDto.JoinDto.builder()
                .memberId(member.getMemberId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static MemberPreferences toMemberPreferences(Members member, Preferences preferences) {
        return MemberPreferences.builder()
                .members(member)
                .preferences(preferences)
                .build();
    }
}
