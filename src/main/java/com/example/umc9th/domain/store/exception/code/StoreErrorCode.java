package com.example.umc9th.domain.store.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    // Store 관련 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE404_1", "해당 상점을 찾을 수 없습니다"),
    STORE_NAME_EMPTY(HttpStatus.BAD_REQUEST, "STORE400_1", "상점 이름을 입력해야 합니다"),
    INVALID_STORE_STATUS(HttpStatus.BAD_REQUEST, "STORE400_2", "유효하지 않은 상점 상태입니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
