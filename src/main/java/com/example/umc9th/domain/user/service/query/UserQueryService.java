package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import jakarta.validation.Valid;

public interface UserQueryService {
    UserResDTO.LoginDTO login(UserReqDTO.@Valid LoginDTO dto);
}
