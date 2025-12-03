package com.example.umc9th.domain.user.converter;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.dto.Req.UserMissionReqDto;
import com.example.umc9th.domain.user.dto.Res.UserMissionResDto;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.mapping.UserMission;
import com.example.umc9th.domain.user.enums.UserStatus;

public class UserMissionConverter {
    public static UserMission toEntity(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(UserStatus.UNCOMPLETED)
                .build();
    }

    public static UserMission UpdateEntity(User user, Mission mission){
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(UserStatus.IN_PROGRESS)
                .build();
    }


    // DTO -> Entitiy
    public static UserMission toUserMission(
            UserMissionReqDto.CreateDTO dto
    ){
        return UserMission.builder()
                .user(dto.userId())
                .mission(dto.mission())
                .build();
    }
}
