package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.user.dto.Req.UserMissionReqDto;
import com.example.umc9th.domain.user.dto.Res.UserMissionResDto;
import com.example.umc9th.domain.user.entity.mapping.UserMission;

public class UserMissionConverter {
    public static UserMissionResDto.CreateDTO toCreateDTO(UserMission userMission) {
        return UserMissionResDto.CreateDTO.builder()
                .userMissionId(userMission.getId())
                .build();
    }

    // DTO -> Entitiy
    public static UserMission toUserMission(
            UserMissionReqDto.CreateDTO dto
    ){
        return UserMission.builder()
                .user(dto.user())
                .mission(dto.mission())
                .build();
    }
}
