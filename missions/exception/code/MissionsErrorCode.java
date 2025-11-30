package com.example.demo.domain.missions.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionsErrorCode implements BaseErrorCode {
    // 사용자가 없음
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,
            "MEMBER404_1",
            "해당 사용자를 찾지 못했습니다."),
    // 미션이 없음
    MISSIONS_NOT_FOUND(HttpStatus.NOT_FOUND,
            "MISSION404_1",
            "해당 미션을 찾지 못했습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
