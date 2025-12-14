package com.example.chunsam.domain.member.dto.res;

import com.example.chunsam.domain.mission.enums.MissionStatus;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class MemberMissionResDto {
    private Long mission_id;
    private Long member_id;
    private MissionStatus issuccess;   // BEFORE / IN_PROGRESS / COMPLETED
    private LocalDate successDate;

}
