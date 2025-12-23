package com.example.umc9th.domain.user.dto.Res;

import com.example.umc9th.domain.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class UserResDto {

    private final Long id;
    private final String email;
    private final String name;
    private final String status;
    private final String createdAt;

    @Builder
    @Getter
    public static class Exception {
        private String errorMessage;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUser {
        private Long id;           // 유저 아이디
        private String username;   // 사용자 이름
        private String email;      // 이메일
        private String phone;      // 전화번호 (선택사항)
    }

    @Getter
    @Builder
    public static class JoinDTO {
        private Long id;
        private String email;
        private String name;
        private LocalDateTime createdAt;

        public static JoinDTO from(User user) {
            return JoinDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
        }
    }

    @Getter
    @Builder
    public static class UserInfoDTO {
        private Long id;
        private String email;
        private String name;

        public static UserInfoDTO from(User user) {
            return UserInfoDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .build();
        }
    }

    // 로그인
    @Builder
    public record LoginDTO(
            Long userId,
            String accessToken
    ){}
}