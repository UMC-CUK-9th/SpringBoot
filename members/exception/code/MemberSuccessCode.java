package com.example.demo.domain.members.exception.code;

import com.example.demo.global.apiPayLoad.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    CREATED(HttpStatus.CREATED, "MEMBER201", "회원가입에 성공했습니다."),
    FOUND(HttpStatus.OK, "MEMBER200", "조회에 성공했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}