package com.example.umc9th.domain.region.service.command;

import com.example.umc9th.domain.region.converter.RegionConverter;
import com.example.umc9th.domain.region.dto.req.RegionReqDTO;
import com.example.umc9th.domain.region.dto.res.RegionResDTO;
import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.domain.region.exception.RegionErrorCode;
import com.example.umc9th.domain.region.repository.RegionRepository;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService {

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public RegionResDTO.CreateDTO createRegion(RegionReqDTO.CreateDTO dto) {

        // 이미 존재하는 지역인지 체크
        if (regionRepository.existsByRegionName(dto.getRegionName())) {
            throw new GeneralException(RegionErrorCode.REGION_DUPLICATED);
        }

        Region region = RegionConverter.toEntity(dto);
        Region saved = regionRepository.save(region);

        return RegionConverter.toCreateDTO(saved);
    }
}