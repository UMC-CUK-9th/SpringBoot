package com.example.demo.domain.missions.exception;

import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import com.example.demo.global.apiPayLoad.exception.GeneralException;

public class MissionsException extends GeneralException {
    public MissionsException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
