package com.example.demo.domain.test.controller;

import com.example.demo.domain.test.converter.testConverter;
import com.example.demo.domain.test.dto.res.testResDto;
import com.example.demo.domain.test.service.query.testQueryService;
import com.example.demo.global.apiPayLoad.ApiResponse;
import com.example.demo.global.apiPayLoad.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final testQueryService testQueryService;

    @GetMapping("/test")
    public ApiResponse<testResDto.Testing> test() {

        GeneralSuccessCode code = GeneralSuccessCode.OK;

        return ApiResponse.success(
                code,
                testConverter.toTestingDTO("This is Test!")
        );
    }

    // 예외 상황
    @GetMapping("/exception")
    public ApiResponse<testResDto.Exception> exception(
            @RequestParam Long flag
    ) {
        testQueryService.checkFlag(flag);

        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.success(code, testConverter.toExceptionDTO("This is Test!"));
    }
}