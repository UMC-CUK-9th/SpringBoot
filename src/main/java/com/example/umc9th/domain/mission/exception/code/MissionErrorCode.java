package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    // Mission 관련 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404_1", "해당 미션을 찾을 수 없습니다"),
    INVALID_MISSION_DEADLINE(HttpStatus.BAD_REQUEST, "MISSION400_1", "유효하지 않은 미션 마감일입니다"),
    INVALID_MISSION_POINT(HttpStatus.BAD_REQUEST, "MISSION400_2", "미션 포인트는 0 이상이어야 합니다"),
    MISSION_STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION400_3", "해당 상점이 존재하지 않습니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
