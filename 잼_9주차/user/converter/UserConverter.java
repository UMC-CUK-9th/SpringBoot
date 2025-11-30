package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserConverter {
//    public static UserResDto.JoinDTO toJoinDTO(User user) {
//        return UserResDto.JoinDTO.builder()
//                .userId(user.getId())
//                .createAt(user.getCreatedAt())
//                .build();
//    }

    // Req DTO -> Entitiy
    public User toEntitiy(
            UserReqDto.CreateUser dto
    ){
        return User.builder()
                .name(dto.getName())
                .birth(dto.getEmail())
                .address(dto.getPassword())
                .build();
    }

//    Entitiy -> Res DTO
    public UserResDto.CreateUser toCreateUserRes(User user) {
        return UserResDto.CreateUser.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .createdAt(user.getCreatedAt())
            .build();
    }
}
