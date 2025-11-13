package com.example.umc9th.domain.user.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    // User 관련 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER404_1", "해당 사용자를 찾을 수 없습니다"),
    INVALID_USER_NAME(HttpStatus.BAD_REQUEST, "USER400_1", "유효하지 않은 사용자 이름입니다"),
    INVALID_USER_BIRTH(HttpStatus.BAD_REQUEST, "USER400_2", "유효하지 않은 생년월일입니다"),
    USER_ADDRESS_EMPTY(HttpStatus.BAD_REQUEST, "USER400_3", "주소를 입력해야 합니다"),
    DUPLICATE_SOCIAL_UID(HttpStatus.CONFLICT, "USER409_1", "이미 가입된 소셜 계정입니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
