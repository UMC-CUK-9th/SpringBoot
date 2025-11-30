package com.example.umc9th.domain.usermission.exception;

import com.example.umc9th.global.apiPayload.code.exception.GeneralException;

public class UserMissionException extends GeneralException {

    public UserMissionException(UserMissionErrorCode errorCode) {
        super(errorCode);
    }
}
