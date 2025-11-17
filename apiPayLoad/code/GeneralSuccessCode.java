package com.example.demo.global.apiPayLoad.code;

import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public enum GeneralSuccessCode implements BaseSuccessCode{
    OK(HttpStatus.OK, "COMMON200", "요청에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    private GeneralSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}