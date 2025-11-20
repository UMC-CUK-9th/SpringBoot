package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "가게를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_2", "유저를 찾을 수 없습니다."),
    INVALID_SCORE(HttpStatus.BAD_REQUEST, "REVIEW400_1", "평점은 0~5 사이여야 합니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
