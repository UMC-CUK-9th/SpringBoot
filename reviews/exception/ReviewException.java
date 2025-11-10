package com.example.demo.domain.reviews.exception;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import com.example.demo.global.apiPayLoad.exception.GeneralException;

public class ReviewException extends GeneralException {
    public ReviewException(BaseErrorCode code) {
        super(code);
    }
}
