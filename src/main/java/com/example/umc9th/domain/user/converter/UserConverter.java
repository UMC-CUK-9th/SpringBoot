package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.auth.enums.Role;

public class UserConverter {

    // Entity -> DTO
    public static UserResDTO.JoinDTO toJoinDTO(
            User user   
    ){
        return UserResDTO.JoinDTO.builder()
                .userId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    // DTO, Salted Password, Role -> Entity
    public static User toUser(
            UserReqDTO.JoinDTO dto,
            String password,
            Role role
    ){
        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(password) // 추가된 코드
                .role(role)         // 추가된 코드
                .birth(dto.birth())
                .address(dto.address())
                .detailAddress(dto.specAddress())
                .gender(dto.gender())
                .build();

    }
}
