package com.example.demo.domain.test.service.query;

import com.example.demo.domain.test.exception.code.testErrorCode;
import com.example.demo.domain.test.exception.testException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class testQueryServiceImpl implements testQueryService {

    @Override
    public void checkFlag(Long flag){
        if (flag == 1){
            throw new testException(testErrorCode.TEST_EXCEPTION);
        }
    }
}