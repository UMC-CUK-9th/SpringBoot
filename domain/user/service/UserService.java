package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserInfoDto> getUserBasicInfo() {
        return userRepository.findUserBasicInfo();
    }
}