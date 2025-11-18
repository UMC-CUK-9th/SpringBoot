package com.example.umc9th.domain.region.service.command;

import com.example.umc9th.domain.region.dto.req.RegionReqDTO;
import com.example.umc9th.domain.region.dto.res.RegionResDTO;

public interface RegionCommandService {

    RegionResDTO.CreateDTO createRegion(RegionReqDTO.CreateDTO request);
}