package com.example.umc9th.global.apiPayload.code;

import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {

    // 7주차 미션 - BaseSuccessCode (성공 응답 형식 인터페이스) 작성
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}