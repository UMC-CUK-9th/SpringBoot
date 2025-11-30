package com.example.demo.global.apiPayLoad.handler;

import com.example.demo.global.apiPayLoad.ApiResponse;
import com.example.demo.global.apiPayLoad.code.BaseErrorCode;
import com.example.demo.global.apiPayLoad.code.GeneralErrorCode;
import com.example.demo.global.apiPayLoad.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 애플리케이션에서 발생하는 커스텀 예외
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(
            GeneralException ex
    ) {

        BaseErrorCode errorCode = ex.getCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.onFailure(
                        errorCode,
                        null
                ));
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception ex
    ) {
        // 정의되지 않은 예외는 내부 서버 오류
        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(code.getStatus())
                .body(ApiResponse.onFailure(
                        code,
                        ex.getMessage()
                ));
    }

    // 컨트롤러 메서드에서 @Valid 어노테이션을 사용하여 DTO의 유효성 검사를 수행
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        // 검사에 실패한 필드와 그에 대한 메시지를 저장하는 Map
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        GeneralErrorCode code = GeneralErrorCode.VALID_FAIL;
        ApiResponse<Map<String, String>> errorResponse = ApiResponse.onFailure(code, errors);

        // 에러 코드, 메시지와 함께 errors를 반환
        return ResponseEntity.status(code.getStatus()).body(errorResponse);
    }
}
