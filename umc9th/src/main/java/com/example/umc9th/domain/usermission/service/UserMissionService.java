package com.example.umc9th.domain.usermission.service;

import com.example.umc9th.domain.usermission.dto.UserMissionResponse;
import com.example.umc9th.domain.usermission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserMissionService {

    private final UserMissionRepository userMissionRepository;

    public List<UserMissionResponse> getUserMissions(Long userId) {
        List<Object[]> results = userMissionRepository.findUserMissionsByUserId(userId);

        return results.stream()
                .map(obj -> new UserMissionResponse(
                        (String) obj[3],
                        (String) obj[2],
                        (Integer) obj[0],
                        (String) obj[1]
                ))
                .collect(Collectors.toList());
    }
}
