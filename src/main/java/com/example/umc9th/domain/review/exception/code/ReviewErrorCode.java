package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    // Review 관련 에러
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW404_1", "해당 리뷰를 찾을 수 없습니다"),
    INVALID_REVIEW_STAR(HttpStatus.BAD_REQUEST, "REVIEW400_1", "별점은 0.5~5.0 사이여야 합니다"),
    REVIEW_CONTENT_EMPTY(HttpStatus.BAD_REQUEST, "REVIEW400_2", "리뷰 내용을 입력해야 합니다"),
    REVIEW_STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "REVIEW400_3", "해당 상점이 존재하지 않습니다"),
    REVIEW_USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "REVIEW400_4", "해당 사용자가 존재하지 않습니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
