package com.example.umc9th.domain.region.controller;

import com.example.umc9th.domain.region.dto.req.RegionReqDTO;
import com.example.umc9th.domain.region.dto.res.RegionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Region API", description = "지역 관련 API")
@Validated
@RequestMapping("/regions")
public interface RegionControllerDocs {

    @Operation(
            summary = "지역 등록 API By 노바 (개발 완료)",
            description = "새로운 지역을 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "지역 등록 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값")
    })
    @PostMapping("")
    ApiResponse<RegionResDTO.CreateDTO> createRegion(
            @RequestBody(description = "지역 생성 요청", required = true)
            @Valid RegionReqDTO.CreateDTO dto
    );
}