package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.exception.UserException;
import com.example.umc9th.domain.user.exception.code.UserErrorCode;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    public UserResDTO.CreateUserResultDTO createUser(UserReqDTO.CreateUserDTO req) {
        // 유효성 검사
        if (req.getName() == null || req.getName().isEmpty()) {
            throw new UserException(UserErrorCode.INVALID_USER_NAME);
        }

        if (req.getBirth() == null || req.getBirth().isAfter(LocalDate.now())) {
            throw new UserException(UserErrorCode.INVALID_USER_BIRTH);
        }

        if (req.getAddress() == null || req.getAddress().isEmpty()) {
            throw new UserException(UserErrorCode.USER_ADDRESS_EMPTY);
        }

        // User Entity 생성 및 저장
        User user = User.builder()
                .name(req.getName())
                .gender(req.getGender())
                .birth(req.getBirth())
                .address(req.getAddress())
                .socialUid(req.getSocialUid())
                .socialType(req.getSocialType())
                .build();

        User savedUser = userRepository.save(user);

        return UserConverter.toCreateUserResultDTO(savedUser);
    }

    @Override
    public void updateUser(Long userId, UserReqDTO.UpdateUserDTO req) {
        // 사용자 존재 여부 검증
        userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 유효성 검사
        if (req.getName() != null && req.getName().isEmpty()) {
            throw new UserException(UserErrorCode.INVALID_USER_NAME);
        }

        if (req.getAddress() != null && req.getAddress().isEmpty()) {
            throw new UserException(UserErrorCode.USER_ADDRESS_EMPTY);
        }

        // User Entity 업데이트 (필요에 따라 업데이트 메서드 추가)
    }

    @Override
    public void deleteUser(Long userId) {
        // 사용자 존재 여부 검증
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // User Entity 삭제
        userRepository.delete(user);
    }
}
