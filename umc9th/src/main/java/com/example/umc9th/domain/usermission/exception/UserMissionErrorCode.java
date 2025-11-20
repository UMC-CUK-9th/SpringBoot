package com.example.umc9th.domain.usermission.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserMissionErrorCode implements BaseErrorCode {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "UM000", "유저를 찾을 수 없습니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "UM001", "미션을 찾을 수 없습니다."),
    USER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "UM002", "유저 미션을 찾을 수 없습니다."),
    MISSION_ALREADY_CHALLENGING(HttpStatus.BAD_REQUEST, "UM003", "이미 도전 중인 미션입니다."),
    INVALID_USER_MISSION_STATUS(HttpStatus.BAD_REQUEST, "UM004", "유효하지 않은 미션 상태입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
