package com.example.umc9th.domain.member.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 8주차 예제 - 회원가입 API
@Getter
@AllArgsConstructor
public enum FoodErrorCode implements BaseErrorCode {

    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND,
            "FOOD404_1",
            "해당 음식을 찾지 못했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}