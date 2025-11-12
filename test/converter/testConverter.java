package com.example.demo.domain.test.converter;

import com.example.demo.domain.test.dto.res.testResDto;

public class testConverter {

    // 객체 -> DTO
    public static testResDto.Testing toTestingDTO(
            String testing
    ) {
        return testResDto.Testing.builder()
                .testing(testing)
                .build();
    }

    // 객체 -> DTO
    public static testResDto.Exception toExceptionDTO(
            String testing
    ){
        return testResDto.Exception.builder()
                .testString(testing)
                .build();
    }
}