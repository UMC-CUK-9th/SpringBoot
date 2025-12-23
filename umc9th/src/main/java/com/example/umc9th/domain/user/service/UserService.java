package com.example.umc9th.domain.user.service;

import com.example.umc9th.domain.user.converter.UserConverter;
import com.example.umc9th.domain.user.dto.UserReqDTO;
import com.example.umc9th.domain.user.dto.UserResDTO;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.Role;
import com.example.umc9th.domain.user.exception.UserErrorCode;
import com.example.umc9th.domain.user.exception.UserException;
import com.example.umc9th.domain.user.repository.UserRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.code.exception.GeneralException;
import com.example.umc9th.global.security.CustomUserDetails;
import com.example.umc9th.global.security.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Password Encoder
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // 유저 단건 조회
    public User getUserById(Long id) {
        User user = userRepository.findByIdAndInactiveDateIsNull(id);
        if (user == null) {
            throw new GeneralException(GeneralErrorCode.NOT_FOUND);
        }
        return user;
    }

    // 회원가입
    public UserResDTO.JoinDTO signup(UserReqDTO.JoinDTO dto) {

        // 솔트된 비밀번호 생성
        String encodedPassword = passwordEncoder.encode(dto.password());

        // 사용자 생성: 일반 사용자 / 관리자는 따로 API 만들어서 관리
        User user = UserConverter.toUser(dto, encodedPassword, Role.ROLE_USER);

        // 저장
        userRepository.save(user);

        // 반환 DTO 변환
        return UserResDTO.JoinDTO.builder()
                .userId(user.getId())
                .createAt(user.getCreatedAt())
                .build();
    }

    public UserResDTO.LoginDTO login(
            UserReqDTO.@Valid LoginDTO dto
    ) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));

        if (!passwordEncoder.matches(dto.userPassword(), user.getUserPassword())){
            throw new UserException(UserErrorCode.INVALID);
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        String accessToken = jwtUtil.createAccessToken(customUserDetails);

        return UserConverter.toLoginDTO(user,accessToken);
    }

//    @Override
//    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new org.springframework.security.core.userdetails.UsernameNotFoundException("User not found with email: " + email));
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getUserPassword())
//                .roles(user.getRole().name().replace("ROLE_", "")) // Spring Security expects roles without prefix for builder if using roles() method, or use authorities()
//                .build();
//    }
}
