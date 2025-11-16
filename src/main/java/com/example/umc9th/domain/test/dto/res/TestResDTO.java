package com.example.umc9th.domain.test.dto.res;


import lombok.Builder;
import lombok.Getter;

public class TestResDTO {

    // 7주차 실습 - TestAPI
    @Builder
    @Getter
    public static class Testing {
        private String testString;
    }

    @Builder
    @Getter
    public static class Exception {
        private String testString;
    }
}