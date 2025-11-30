package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;

public interface MemberCommandService {

    // 8주차 예제 - 회원가입 API
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}