package com.example.demo.domain.members.converter;

import com.example.demo.domain.members.dto.MemberReqDto;
import com.example.demo.domain.members.dto.MemberResDto;
import com.example.demo.domain.members.entity.Members;
import com.example.demo.domain.members.entity.Preferences;
import com.example.demo.domain.members.entity.mapping.MemberPreferences;


public class MemberConverter {

    public static Members toMember(MemberReqDto.JoinDto dto) {
        return Members.builder()
                .name(dto.name())
                .nickname(dto.nickname())
                .email(dto.email())
                .point(0)
                .address(dto.address())
                .birth(dto.birth())
                .gender(dto.gender())
                .logType(dto.logType())
                .isPhoneVerified(false)
                .isActive(true)
                .build();
    }

    public static MemberResDto.JoinDto toJoinDTO(Members member) {
        return MemberResDto.JoinDto.builder()
                .userId(member.getMemberId())
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
