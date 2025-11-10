package com.example.demo.domain.test.dto.res;

import lombok.Builder;
import lombok.Getter;

public class testResDto {

    @Builder
    @Getter
    public static class Testing {
        private String testing;
    }

    @Builder
    @Getter
    public static class Exception {
        private String testString;
    }
}