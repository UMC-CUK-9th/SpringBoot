package com.example.demo.domain.test.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum testErrorCode implements BaseErrorCode {

    // For test
    TEST_EXCEPTION(HttpStatus.BAD_REQUEST, "TEST400_1", "이거는 테스트"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    private testErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
