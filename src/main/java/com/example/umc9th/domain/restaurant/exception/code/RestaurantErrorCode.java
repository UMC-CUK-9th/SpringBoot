package com.example.umc9th.domain.restaurant.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
@Getter
@AllArgsConstructor
public enum RestaurantErrorCode implements BaseErrorCode {

    REST_NOT_FOUND(HttpStatus.NOT_FOUND,
            "REST404_1",
            "해당 가게를 찾을 수 없습니다."),

    REST_DUPLICATED(HttpStatus.CONFLICT,
            "REST409_1",
            "해당 지역에 이미 동일한 상호가 존재합니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}