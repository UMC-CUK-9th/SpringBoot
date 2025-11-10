package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {

    // 7주차 미션 - GeneralSuccessCode (성공 상태 Enum) 작성
    // 200 OK: 일반 조회/수정 성공
    OK(HttpStatus.OK,
            "COMMON200_1",
            "성공적으로 요청을 처리하였습니다."),

    // 201 Created: 생성 성공 (POST)
    CREATED(HttpStatus.CREATED,
            "COMMON201_1",
            "리소스가 성공적으로 생성되었습니다."),

    // 204 No Content: 본문 없이 성공 (삭제 등)
    NO_CONTENT(HttpStatus.NO_CONTENT,
            "COMMON204_1",
            "응답 본문 없이 요청이 성공적으로 처리되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}