package com.example.umc9th.domain.store.service;

import com.example.umc9th.domain.user.dto.UserInfoDto;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final UserRepository storeRepository;

    public List<UserInfoDto> getUserBasicInfo() {
        return storeRepository.findStoreBasicInfo();
    }
}