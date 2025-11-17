package com.example.demo.domain.missions.service.command;

import com.example.demo.domain.missions.dto.MissionsReqDto;
import com.example.demo.domain.missions.dto.MissionsResDto;

public interface MissionsCommandService {
    MissionsResDto challengeMission(MissionsReqDto request);
}
