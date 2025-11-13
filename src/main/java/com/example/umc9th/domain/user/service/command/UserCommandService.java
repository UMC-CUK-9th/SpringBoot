package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;

public interface UserCommandService {
    UserResDTO.CreateUserResultDTO createUser(UserReqDTO.CreateUserDTO req);
    void updateUser(Long userId, UserReqDTO.UpdateUserDTO req);
    void deleteUser(Long userId);
}
