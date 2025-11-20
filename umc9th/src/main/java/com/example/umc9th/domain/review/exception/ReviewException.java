package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayload.code.exception.GeneralException;
import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
