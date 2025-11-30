package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.User;

public class UserConverter {
    public static UserResDto.JoinDTO toJoinDTO(User user) {
        return UserResDto.JoinDTO.builder()
                .userId(user.getId())
                .createAt(user.getCreatedAt())
                .build();
    }

    // DTO -> Entitiy
    public static User toUser(
            UserReqDto.JoinDTO dto
    ){
        return User.builder()
                .name(dto.name())
                .birth(dto.birth())
                .address(dto.specAddress())
                .detailAddress(dto.specAddress())
                .gender(dto.gender())
                .build();
    }
}
