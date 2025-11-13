package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.User;

public class UserConverter {

    // User Entity -> 기본 정보 DTO 변환
    public static UserResDTO.UserInfoDTO toUserInfoDTO(User user) {
        return UserResDTO.UserInfoDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .birth(user.getBirth())
                .address(user.getAddress())
                .build();
    }

    // User Entity -> 상세 정보 DTO 변환
    public static UserResDTO.UserDetailDTO toUserDetailDTO(User user) {
        return UserResDTO.UserDetailDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .gender(user.getGender())
                .birth(user.getBirth())
                .address(user.getAddress())
                .socialUid(user.getSocialUid())
                .socialType(user.getSocialType())
                .build();
    }

    // User Entity -> 생성 결과 DTO 변환
    public static UserResDTO.CreateUserResultDTO toCreateUserResultDTO(User user) {
        return UserResDTO.CreateUserResultDTO.builder()
                .userId(user.getId())
                .name(user.getName())
                .socialType(user.getSocialType())
                .build();
    }
}
