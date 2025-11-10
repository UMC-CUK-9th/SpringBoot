package com.example.demo.domain.test.exception;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import com.example.demo.global.apiPayLoad.exception.GeneralException;

public class testException extends GeneralException {
    public testException(BaseErrorCode code) {
        super(code);
    }
}
