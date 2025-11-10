package com.example.demo.domain.reviews.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "REVIEW200", "요청에 성공했습니다."),
    TEST_EXCEPTION(HttpStatus.OK, "REVIEW200_1", "이거는 테스트"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    private ReviewSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}


