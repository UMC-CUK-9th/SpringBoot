package com.example.umc9th.domain.user.exception.code;

import com.example.umc9th.global.apiPayload.exception.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserMissionSuccessCode implements BaseSuccessCode {
    FOUND(HttpStatus.OK,
            "MEMBER200_1",
            "성공적으로 사용자 미션을 조회했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
