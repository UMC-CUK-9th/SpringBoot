package com.example.umc9th.domain.test.service.query;

import com.example.umc9th.domain.test.exception.TestException;
import com.example.umc9th.domain.test.exception.code.TestErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    // 7주차 실습 - TestAPI
    @Override
    public void checkFlag(Long flag){
        if (flag == 1){
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}