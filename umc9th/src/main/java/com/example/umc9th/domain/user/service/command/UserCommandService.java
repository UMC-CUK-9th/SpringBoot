package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.service.query.TestQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Long flag){}
}
