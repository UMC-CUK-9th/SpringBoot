package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.test.exception.TestException;
import com.example.umc9th.domain.test.exception.code.TestErrorCode;
import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.exception.UserException;
import com.example.umc9th.domain.user.exception.code.UserErrorCode;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import com.example.umc9th.global.apiPayload.exception.code.GeneralErrorCode;
import com.example.umc9th.global.config.CustomUserDetails;
import com.example.umc9th.global.config.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    @Override
    public UserResDto.JoinDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        return UserConverter.toJoinDTO(user);
    }

    @Override
    public UserResDto.JoinDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        return UserConverter.toJoinDTO(user);
    }

    @Override
    public List<UserResDto.UserInfoDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserResDto.UserInfoDTO::from)
                .toList();
    }

    @Override
    public void checkFlag(Long flag) {
        if(flag == 0) {
            throw new GeneralException(GeneralErrorCode.NOT_FOUND);
        }
    }

    @Override
    public UserResDto.LoginDTO login(
            UserReqDto.@Valid LoginDTO dto
    ) {

        // Member 조회
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 비밀번호 검증
        if (!encoder.matches(dto.password(), user.getPassword())){
            throw new UserException(UserErrorCode.USER_NOT_FOUND);
        }

        // JWT 토큰 발급용 UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(user);

        // 엑세스 토큰 발급
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // DTO 조립
        return UserConverter.toLoginDTO(user, accessToken);
    }

//    @Override
//    public List<UserResDto.JoinDTO> searchUsers(UserSearchCondition condition) {
//        return userRepository.search(condition).stream()
//                .map(UserResponse::from)
//                .toList();
//    }
//    @Override
//    public void checkFlag(Long flag){
//        if (flag == 1){
//            throw new TestException(TestErrorCode.TEST_EXCEPTION);
//        }
//    }
}