package com.example.demo.domain.reviews.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewErrorCode implements BaseErrorCode {
    REVIEW_EXCEPTION(HttpStatus.BAD_REQUEST, "REVIEW404_1", "리뷰가 존재하지 않습니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;

    ReviewErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}