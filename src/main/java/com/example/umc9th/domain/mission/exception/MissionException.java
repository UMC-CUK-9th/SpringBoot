package com.example.umc9th.domain.mission.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

// 8주차 미션 - 가게의 미션을 도전 중인 미션에 추가(미션 도전하기) API
public class MissionException extends GeneralException {
    public MissionException(BaseErrorCode code) {
        super(code);
    }
}