package com.example.demo.domain.members.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum PreferencesErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD404", "해당 음식을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    private PreferencesErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
