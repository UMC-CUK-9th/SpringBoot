package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.user.dto.Res.UserResDto;

import java.util.List;

public interface UserQueryService {

    UserResDto.CreateUser findById(Long id);

    UserResDto findByEmail(String email);

    List<UserResDto> findAll();

    List<UserResDto> searchUsers(UserSearchCondition condition);
}