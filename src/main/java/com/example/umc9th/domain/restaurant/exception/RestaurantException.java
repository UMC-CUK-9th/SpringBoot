package com.example.umc9th.domain.restaurant.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public class RestaurantException extends GeneralException {
    public RestaurantException(BaseErrorCode code) {
        super(code);
    }
}