package com.example.umc9th.global.apiPayload.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode{

    OK(HttpStatus.OK, "S000", "요청이 성공적으로 처리되었습니다."),

    // ✅ 도메인별 성공 코드
    USER_CREATED(HttpStatus.CREATED, "U001", "사용자가 성공적으로 생성되었습니다."),
    USER_UPDATED(HttpStatus.OK, "U002", "사용자 정보가 성공적으로 수정되었습니다."),
    REVIEW_ADDED(HttpStatus.CREATED, "R001", "리뷰가 성공적으로 등록되었습니다."),
    STORE_FETCHED(HttpStatus.OK, "S001", "가게 정보 조회에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
