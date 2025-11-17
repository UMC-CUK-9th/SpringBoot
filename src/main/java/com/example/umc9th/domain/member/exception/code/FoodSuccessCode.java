package com.example.umc9th.domain.member.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 8주차 예제 - 회원가입 API
@Getter
@AllArgsConstructor
public enum FoodSuccessCode implements BaseSuccessCode {

    FOOD_FOUND(HttpStatus.OK,
            "MEMBER200_1",
            "성공적으로 음식을 조회했습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
