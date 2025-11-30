package com.example.umc9th.domain.user.exception.food;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum FoodErrorCode implements BaseErrorCode {

    // Food 관련 에러
    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD404_1", "해당 음식을 찾을 수 없습니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
