package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.user.dto.res.UserResDTO;

public interface UserQueryService {
    UserResDTO.UserInfoDTO getUserInfo(Long userId);
    UserResDTO.UserDetailDTO getUserDetail(Long userId);
}
