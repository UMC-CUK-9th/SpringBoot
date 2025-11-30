package com.example.umc9th.domain.store.service.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {
    @Override
    public void checkFlag(Long flag) {

    }

//    @Override
//    public void checkFlag(Long flag){
//        if (flag == 1){
//            throw new TestException(TestErrorCode.TEST_EXCEPTION);
//        }
//    }
}