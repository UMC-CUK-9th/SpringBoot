package com.example.demo.domain.test.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseSuccessCode;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
public enum testSuccessCode implements BaseSuccessCode {

    OK(HttpStatus.OK, "TEST200", "요청에 성공했습니다."),
    TEST_EXCEPTION(HttpStatus.OK, "TEST200_1", "이거는 테스트"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    private testSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}