package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO.JoinDTO;

public interface UserCommandService {
    JoinDTO signup(com.example.umc9th.domain.user.dto.req.UserReqDTO.JoinDTO dto);
    
}
