package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserQueryService {

    UserResDto.JoinDTO findById(Long id);

    UserResDto.JoinDTO findByEmail(String email);

    List<UserResDto.UserInfoDTO> findAll();

    void checkFlag(Long flag);

    UserResDto.LoginDTO login(UserReqDto.@Valid LoginDTO dto);

//    List<UserResDto> searchUsers(UserSearchCondition condition);
}