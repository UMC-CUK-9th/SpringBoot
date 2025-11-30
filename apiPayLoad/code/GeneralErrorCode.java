package com.example.demo.global.apiPayLoad.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralErrorCode implements BaseErrorCode{

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "COMMON500_1",
                    "예기치 않은 서버 에러가 발생했습니다."),
    VALID_FAIL(HttpStatus.BAD_REQUEST, "COMMON400_1", "요청 매개변수가 올바르지 않습니다.");
            ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
