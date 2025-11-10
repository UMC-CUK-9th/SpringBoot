package com.example.umc9th.domain.test.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {

    // 7주차 실습 - TestAPI
    public TestException(BaseErrorCode code) {
        super(code);
    }
}