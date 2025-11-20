package com.example.umc9th.domain.usermission.service;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.entity.UserMission;
import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import com.example.umc9th.domain.usermission.exception.UserMissionErrorCode;
import com.example.umc9th.domain.usermission.exception.UserMissionException;
import com.example.umc9th.domain.usermission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    public List<UserMissionResponse> getUserMissions(Long userId) {
        return userMissionRepository.findUserMissionsByUserId(userId);
    }

    public Long challengeMission(Long missionId) {

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new UserMissionException(UserMissionErrorCode.USER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new UserMissionException(UserMissionErrorCode.MISSION_NOT_FOUND));

        boolean duplicated = userMissionRepository.existsByUserIdAndMissionId(1L, missionId);
        if (duplicated) {
            throw new UserMissionException(UserMissionErrorCode.MISSION_ALREADY_CHALLENGING);
        }

        UserMission userMission = UserMission.builder()
                .user(user)
                .mission(mission)
                .userMissionStatus(UserMissionStatus.START)
                .userMissionStartedAt(LocalDateTime.now())
                .userMissionCompletedAt(null)
                .certificationNumber(null)
                .build();

        return userMissionRepository.save(userMission).getId().longValue();
    }
}
