package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import jakarta.validation.Valid;

public interface MemberQueryService {

    // 10주차 예제 - 2. 간단한 로그인 및 회원가입 구현 (JWT Token 방식)
    MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto);
}
