package com.example.demo.domain.members.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    // 사용자가 없음
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,
            "MEMBER404_1",
            "해당 사용자를 찾지 못했습니다."),

    // 선호도가 없음
    PREF_NOT_FOUND(HttpStatus.NOT_FOUND,
            "PREF404",
            "해당 선호도 항목을 찾을 수 없습니다."),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
