package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.code.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        User user = userRepository.findByIdAndInactiveDateIsNull(id);
        if (user == null) {
            throw new GeneralException(GeneralErrorCode.NOT_FOUND);
        }
        return user;
    }
}
