package main.java.com.example.umc9th.global.apiPayload.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public interface BaseSuccessCode {
//    HttpStatus getStatus();
    String getCode();
    String getMessage();
}