package com.example.umc9th.domain.user.service.query;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.req.UserReqDTO;
import com.example.umc9th.domain.user.dto.res.UserResDTO;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.exception.UserException;
import com.example.umc9th.domain.user.exception.code.UserErrorCode;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.domain.user.security.CustomUserDetails;
import com.example.umc9th.domain.user.security.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    @Override
    public UserResDTO.LoginDTO login(
            UserReqDTO.@Valid LoginDTO dto
    ) {

        // Member 조회
        User user = memberRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND));

        // 비밀번호 검증
        if (!encoder.matches(dto.password(), user.getPassword())){
            throw new UserException(UserErrorCode.INVALID);
        }

        // JWT 토큰 발급용 UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(user);

        // 엑세스 토큰 발급
        String accessToken = jwtUtil.createAccessToken(userDetails);

        // DTO 조립
        return UserResDTO.LoginDTO.builder()
                .userId(user.getId())
                .accessToken(accessToken)
                .build();

    }
}
