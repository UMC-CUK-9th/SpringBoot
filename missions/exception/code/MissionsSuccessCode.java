package com.example.demo.domain.missions.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionsSuccessCode implements BaseSuccessCode {
    CREATED(HttpStatus.CREATED, "MISSION201", "미션을 시작하였습니다.");

    private HttpStatus status;
    private String message;
    private String code;
}