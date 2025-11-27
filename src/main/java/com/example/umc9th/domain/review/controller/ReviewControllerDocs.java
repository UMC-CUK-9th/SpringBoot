package com.example.umc9th.domain.review.controller;


import com.example.umc9th.domain.review.dto.Req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.Res.ReviewResDTO;
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

@Tag(name = "Review API", description = "리뷰 관련 API")
@Validated
public interface ReviewControllerDocs {

    @Operation(
            summary = "특정 가게에 리뷰 등록 API By 노바 (개발 완료)",
            description = "특정 가게(restId)에 리뷰를 등록합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "리뷰 생성 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게 또는 회원을 찾을 수 없음")
    })
    ApiResponse<ReviewResDTO.CreateReviewDTO> createReview(
            @Parameter(description = "리뷰를 등록할 가게 ID", example = "1")
            @PathVariable("restId") Long restId,
            @Parameter(description = "리뷰를 작성한 회원 ID", example = "1")
            @RequestParam("memberId") Long memberId,
            @RequestBody @Valid ReviewReqDTO.CreateReviewDTO request
    );

    @Operation(
            summary = "특정 가게의 리뷰 목록 조회 API By 노바 (개발 완료)",
            description = "특정 가게(restId)에 작성된 리뷰 목록을 페이지네이션(10개 단위)으로 조회합니다. page는 1 이상입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "리뷰 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값 (page < 1 등)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "가게 또는 리뷰를 찾을 수 없음")
    })

    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getRestReviews(
            @Parameter(description = "리뷰를 조회할 가게 ID", example = "1")
            @PathVariable("restId") Long restId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    );

    @Operation(
            summary = "특정 회원이 작성한 리뷰 목록 조회 API by 노바 (개발 완료)",
            description = "특정 회원(memberId)이 작성한 리뷰 목록을 페이지네이션(10개 단위)으로 조회합니다. page는 1 이상입니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "내가 작성한 리뷰 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 값 (page < 1 등)"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "회원 또는 리뷰를 찾을 수 없음")
    })
    ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getMyReviews(
            @Parameter(description = "리뷰를 조회할 회원 ID", example = "1")
            @PathVariable("memberId") Long memberId,
            @Parameter(description = "조회할 페이지 번호 (1 이상)", example = "1")
            @RequestParam(name = "page", defaultValue = "1") @ValidPage Integer page
    );
}