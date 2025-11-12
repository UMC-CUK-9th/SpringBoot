package com.example.demo.domain.reviews.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseSuccessCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ReviewSuccessCode implements BaseSuccessCode {
    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REV201", "리뷰가 성공적으로 생성되었습니다."),
    REVIEW_SEARCH_SUCCESS(HttpStatus.OK, "REV200", "리뷰 검색이 성공적으로 완료되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ReviewSuccessCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
