package com.example.demo.domain.users.service;

import com.example.demo.domain.users.entity.Users;
import com.example.demo.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public Users getMyPageInfo(Long userId) {
        // 사용자 검색
        Optional<Users> optionalUser = userRepository.findById(userId);

        // 예외처리
        return optionalUser.orElseThrow(() -> new NoSuchElementException("User not found with ID: " + userId));
    }
}