package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.LoginType;
import com.example.umc9th.domain.member.enums.Status;
import com.example.umc9th.global.auth.enums.Role;

public class MemberConverter {

    // 8주차 예제 - 회원가입 API
    // Entity -> DTO
    public static MemberResDTO.JoinDTO toJoinDTO(
            Member member
    ){
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    // 10주차 예제 - 1. 간단한 로그인 및 회원가입 구현 (Session 방식)
    // DTO, Salted Password, Role -> Entity
    public static Member toMember(
            MemberReqDTO.JoinDTO dto,
            String password,
            Role role
    ){
        return Member.builder()
                .name(dto.name())
                .email(dto.email()) // 추가된 코드
                .password(password) // 추가된 코드
                .role(role)         // 추가된 코드
                .birth(dto.birth())
                .address(dto.address())
                .gender(dto.gender())
                .loginType(LoginType.NAVER)    // 기본 로그인 타입
                .status(Status.ACTIVE)         // 기본 상태
                .nickname(dto.name())          // 닉네임 미입력 시 이름으로 대체
                .phone_num(dto.phoneNum())     // 기본 전화번호
                .build();
    }

    // 10주차 예제 - 2. 간단한 로그인 및 회원가입 구현 (JWT Token 방식)
    public static MemberResDTO.LoginDTO toLoginDTO(
            Member member,
            String accessToken
    ){
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}