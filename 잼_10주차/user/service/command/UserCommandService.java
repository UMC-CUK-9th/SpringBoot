package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import org.springframework.stereotype.Service;

@Service
public interface UserCommandService {
    UserResDto.JoinDTO signup(UserReqDto.CreateUser dto);

    // CreateUser DTO 반환용 회원가입 메서드
    UserResDto.CreateUser signupWithCreateUser(UserReqDto.CreateUser dto);
}
