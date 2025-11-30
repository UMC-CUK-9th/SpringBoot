package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.validator.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Mission API", description = "미션 관련 API")
@Validated
public interface MissionControllerDocs {

    @Operation(
            summary = "특정 가게에 미션 등록 API By 노바 (개발 완료)",
            description = "특정 가게(restId)에 미션을 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "미션 생성 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음")
    })
    ApiResponse<MissionResDTO.CreateDTO> createMission(
            @Parameter(description = "미션을 등록할 가게 ID", example = "1")
            @PathVariable Long restId,
            @RequestBody @Valid MissionReqDTO.CreateDTO request
    );

    @Operation(
            summary = "특정 가게의 미션 목록 조회 API By 노바 (개발 완료)",
            description = "특정 가게(restId)에 등록된 미션을 10개씩 페이지네이션하여 조회합니다. page는 1 이상입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값 (page < 1 등)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게를 찾을 수 없음")
    })
    ApiResponse<MissionResDTO.MissionPreviewListDTO> getMissions(
            @Parameter(description = "미션을 조회할 가게 ID", example = "1")
            @PathVariable Long restId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    );
}