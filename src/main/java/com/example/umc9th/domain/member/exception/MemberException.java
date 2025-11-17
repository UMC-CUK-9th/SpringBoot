package com.example.umc9th.domain.member.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

// 8주차 예제 - 회원가입 API
public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode code) {
        super(code);
    }
}