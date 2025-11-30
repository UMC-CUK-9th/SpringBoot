package com.example.demo.domain.members.service.command;

import com.example.demo.domain.members.dto.MemberReqDto;
import com.example.demo.domain.members.dto.MemberResDto;

public interface MemberCommandService {
    // 회원가입
    MemberResDto.JoinDto signup(
            MemberReqDto.JoinDto dto
    );
}
