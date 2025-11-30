package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.User;

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

    // DTO -> Entity
    public static User toUser(
            UserReqDTO.JoinDTO dto
    ){
        return User.builder()
                .name(dto.getName())
                .birth(dto.getBirth())
                .address(dto.getAddress())
                .detailAddress(dto.getSpecAddress())
                .gender(dto.getGender())
                .build();
    }
}
