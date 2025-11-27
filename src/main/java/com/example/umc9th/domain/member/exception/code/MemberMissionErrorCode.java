package com.example.umc9th.domain.member.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberMissionErrorCode implements BaseErrorCode {

    MEMBER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,
            "MEMBERMISSION404_1",
            "회원의 미션을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}