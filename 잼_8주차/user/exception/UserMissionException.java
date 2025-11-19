package com.example.umc9th.domain.user.exception;

import com.example.umc9th.global.apiPayload.exception.GeneralException;
import com.example.umc9th.global.apiPayload.exception.code.BaseErrorCode;

public class UserMissionException extends GeneralException {
    public UserMissionException(BaseErrorCode code) {
        super(code);
    }
}
