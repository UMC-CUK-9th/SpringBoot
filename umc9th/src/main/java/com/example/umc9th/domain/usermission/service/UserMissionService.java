package com.example.umc9th.domain.usermission.service;

import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserMissionRepository userMissionRepository;

    public List<UserMissionResponse> getUserMissions(Long userId) {
        return userMissionRepository.findUserMissionsByUserId(userId);
    }
}
