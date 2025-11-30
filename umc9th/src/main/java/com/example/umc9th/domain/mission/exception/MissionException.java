package com.example.umc9th.domain.mission.exception;

import com.example.umc9th.global.apiPayload.code.exception.GeneralException;
import com.example.umc9th.global.apiPayload.code.BaseErrorCode;

public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
