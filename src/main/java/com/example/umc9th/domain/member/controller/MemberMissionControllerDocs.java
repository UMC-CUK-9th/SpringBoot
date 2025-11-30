package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.validator.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Member Mission API", description = "회원별 미션 관련 API")
@Validated
public interface MemberMissionControllerDocs {

    @Operation(
            summary = "특정 가게의 미션 도전 처리 API By 노바 (개발완료)",
            description = "특정 회원(memberId)이 특정 가게(restId)의 미션(missionId)에 도전합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "미션 도전 등록 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원, 가게 또는 미션을 찾을 수 없음")
    })
    ApiResponse<MissionResDTO.CreateDTO> challengeMission(
            @Parameter(description = "미션이 속한 가게 ID", example = "1")
            @PathVariable("restId") Long restId,
            @Parameter(description = "도전할 미션 ID", example = "1")
            @PathVariable("missionId") Long missionId,
            @Parameter(description = "미션에 도전하는 회원 ID", example = "1")
            @RequestParam("memberId") @NotNull Long memberId
    );

    @Operation(
            summary = "특정 회원이 진행 중인 미션 목록 조회 API By 노바 (개발 완료)",
            description = "특정 회원(memberId)이 진행 중(IN_PROGRESS)인 미션을 페이지네이션(10개 단위)하여 조회합니다. page는 1 이상입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "진행 중인 미션 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값 (page < 1 등)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원 또는 미션을 찾을 수 없음")
    })
    ApiResponse<MemberMissionResDTO.InProgressMissionListDTO> getInProgressMissions(
            @Parameter(description = "미션을 조회할 회원 ID", example = "1")
            @PathVariable("memberId") Long memberId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    );

    @Operation(
            summary = "특정 회원이 진행 중인 미션 완료 처리 API by 노바 (개발 완료)",
            description = "특정 회원(memberId)이 진행 중인 미션(memberMissionId)을 완료(COMPLETED) 상태로 변경하고 변경된 정보를 반환합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "미션 완료 처리 및 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원 또는 미션을 찾을 수 없음")
    })
    ApiResponse<MemberMissionResDTO.CompletedMissionDTO> completeMission(
            @Parameter(description = "미션을 완료할 회원 ID", example = "1")
            @PathVariable("memberId") Long memberId,
            @Parameter(description = "완료 처리할 회원-미션 ID", example = "10")
            @PathVariable("memberMissionId") Long memberMissionId
    );

    @Operation(
            summary = "특정 회원이 완료한 미션 목록 조회 API by 노바 (개발 완료)",
            description = "특정 회원(memberId)이 완료(COMPLETED)한 미션을 페이지네이션(10개 단위)하여 조회합니다. page는 1 이상입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "완료한 미션 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값 (page < 1 등)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원 또는 미션을 찾을 수 없음")
    })
    ApiResponse<MemberMissionResDTO.CompletedMissionListDTO> getCompletedMissions(
            @Parameter(description = "미션을 조회할 회원 ID", example = "1")
            @PathVariable("memberId") Long memberId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    );
}