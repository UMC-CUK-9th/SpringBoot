package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.enums.Role;
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
    public static UserResDto.CreateUser toCreateUserDTO(User user) {
        return UserResDto.CreateUser.builder()
            .id(user.getId())
            .email(user.getEmail())
            .username(user.getName())
            .build();
}


    // Req DTO -> Entitiy
    public static User toEntity(
            UserReqDto.CreateUser dto,
            String password,
            Role role
    ){
        return User.builder()
                .name(dto.name())
                .email(dto.email()) // 추가된 코드
                .password(password) // 추가된 코드
                .role(role)         // 추가된 코드
//                .birth(dto.birth())
//                .address(dto.address())
//                .detailAddress(dto.specAddress())
//                .gender(dto.gender())
                .build();
    }

//    Entitiy -> Res DTO
    public static UserResDto.JoinDTO toJoinDTO(User user) {
        return UserResDto.JoinDTO.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .createdAt(user.getCreatedAt())
            .build();
    }

    public static UserResDto.UserInfoDTO toUserInfoDTO(User user) {
        return UserResDto.UserInfoDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static UserResDto.Exception toExceptionDTO(String message) {
        return UserResDto.Exception.builder()
                .errorMessage(message)
                .build();
    }

    public static UserResDto.LoginDTO toLoginDTO(
            User user,
            String accessToken
    ) {
        return UserResDto.LoginDTO.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .build();
    }
}
