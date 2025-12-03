package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.UserReqDTO;
import com.example.umc9th.domain.user.dto.UserResDTO;
import com.example.umc9th.domain.user.entity.Role;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.UserStatus;

public class UserConverter {

    public static User toUser(
            UserReqDTO.JoinDTO dto,
            String encodedPassword,
            Role role
    ){
        return User.builder()
                .userName(dto.name())
                .nickname(dto.nickname())
                .email(dto.email())
                .userPassword(encodedPassword)
                .role(role)
                .userPhoneNumber(dto.phoneNumber())
                .userStatus(UserStatus.ACTIVE)
                .userPoint(0L)
                .build();
    }

    public static UserResDTO.JoinDTO toJoinDTO(User user){
        return UserResDTO.JoinDTO.builder()
                .userId(user.getId())
                .createAt(user.getCreatedAt())
                .build();
    }

    public static UserResDTO.LoginDTO toLoginDTO(User user, String accessToken){
        return UserResDTO.LoginDTO.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .build();
    }
}

