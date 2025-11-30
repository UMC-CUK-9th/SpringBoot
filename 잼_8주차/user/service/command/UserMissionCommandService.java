package com.example.umc9th.domain.user.service.command;

import com.example.umc9th.domain.user.dto.Req.UserReqDto;
import com.example.umc9th.domain.user.dto.Res.UserResDto;
import org.springframework.stereotype.Service;

@Service
public interface UserMissionCommandService {
    // 회원가입
    UserResDto.CreateDTO mission(
            Long userId, Long missionId, Long storeId
    );

//    @Override
//    public void checkFlag(Long flag){}
}
