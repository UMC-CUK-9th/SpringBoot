package com.example.demo.domain.members.exception;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import com.example.demo.global.apiPayLoad.exception.GeneralException;

public class PreferencesException extends GeneralException {
    public PreferencesException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
