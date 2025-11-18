package com.example.umc9th.domain.region.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RegionErrorCode implements BaseErrorCode {

    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REGION404_1",
            "존재하지 않는 지역입니다."),

    REGION_DUPLICATED(HttpStatus.CONFLICT,
            "REGION409_1",
            "이미 존재하는 지역입니다."),

    REGION_INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "REGION500_1",
            "지역 처리 중 서버 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}