package main.java.com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenralException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User not found: " + id);
    }

    private final BaseErrorCode code;
}
