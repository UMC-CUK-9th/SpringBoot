package com.example.umc9th.domain.region.converter;


import com.example.umc9th.domain.region.dto.req.RegionReqDTO;
import com.example.umc9th.domain.region.dto.res.RegionResDTO;
import com.example.umc9th.domain.region.entity.Region;

public class RegionConverter {

    // 요청 DTO -> 엔티티
    public static Region toEntity(RegionReqDTO.CreateDTO dto) {
        return Region.builder()
                .regionName(dto.getRegionName())
                .build();
    }

    // 엔티티 -> 응답 DTO
    public static RegionResDTO.CreateDTO toCreateDTO(Region region) {
        return RegionResDTO.CreateDTO.builder()
                .regionId(region.getId())
                .regionName(region.getRegionName())
                .build();
    }
}