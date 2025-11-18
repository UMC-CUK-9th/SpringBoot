package com.example.umc9th.domain.region.controller;

import com.example.umc9th.domain.region.dto.req.RegionReqDTO;
import com.example.umc9th.domain.region.dto.res.RegionResDTO;
import com.example.umc9th.domain.region.service.command.RegionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionCommandService regionCommandService;

    @PostMapping("")
    public ApiResponse<RegionResDTO.CreateDTO> createRegion(
            @RequestBody @Valid RegionReqDTO.CreateDTO dto
    ) {
        RegionResDTO.CreateDTO result = regionCommandService.createRegion(dto);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}