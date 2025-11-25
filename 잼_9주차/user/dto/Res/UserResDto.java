package com.example.umc9th.domain.user.dto.Res;

import com.example.umc9th.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    public static class CreateUser {
        private Long id;
        private String email;
        private String name;
        private LocalDateTime createdAt;

        @Builder
        @Getter
        public static class Exception {
            private String userString;
        }

//        return UserResDto.builder()
//                .id(user.getId())
//                .email(user.getEmail())
//                .name(user.getName())
//                .createdAt(user.getCreatedAt().toString())
//                .build();
    }
//
//    public class JoinDTO {
//    }
}
