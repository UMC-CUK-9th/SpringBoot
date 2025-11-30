package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.annotation.CheckPage;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
@Validated
public class ReviewController implements ReviewControllerDocs {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ApiResponse<List<Review>> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception {
        List<Review> result = reviewQueryService.searchReview(filter, type);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }

    // 가게의 리뷰 목록 조회
    @GetMapping("")
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @RequestParam Integer page
    ){
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName,page));
    }

    // 9주차 미션 - 내가 작성한 리뷰 목록 조회
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "사용자가 작성한 리뷰 목록을 페이징하여 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "리뷰 목록 조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 페이지 번호")
    })
    @GetMapping("/my")
    public ApiResponse<ReviewResDTO.MyReviewListDTO> getMyReviews(
            @Parameter(description = "사용자 ID", required = true) @RequestParam Long userId,
            @Parameter(description = "페이지 번호 (1부터 시작)", required = true) @CheckPage @RequestParam Integer page
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, reviewQueryService.getMyReviews(userId, page));
    }
}
