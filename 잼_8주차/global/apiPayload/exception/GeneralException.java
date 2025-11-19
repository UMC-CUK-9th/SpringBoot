package com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.global.apiPayload.exception.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.code.GeneralErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GeneralException extends RuntimeException {

//    public UserNotFoundException(Long id) {
//        super("User not found: " + id);
//    }

    private final BaseErrorCode code;
}
