package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.mission.dto.req.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.service.command.StoreCommandService;
import com.example.umc9th.domain.store.service.query.StoreQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final StoreQueryService storeQueryService;
    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;

    /**
     * 상점 기본 정보 조회
     */
    @GetMapping("/{storeId}")
    public ApiResponse<StoreResDTO.StoreInfoDTO> getStoreInfo(
            @PathVariable Long storeId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                storeQueryService.getStoreInfo(storeId)
        );
    }

    /**
     * 상점 상세 정보 조회
     */
    @GetMapping("/{storeId}/detail")
    public ApiResponse<StoreResDTO.StoreDetailDTO> getStoreDetail(
            @PathVariable Long storeId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(
                code,
                storeQueryService.getStoreDetail(storeId)
        );
    }

    /**
     * 상점 생성
     */
    @PostMapping
    public ApiResponse<StoreResDTO.CreateStoreResultDTO> createStore(
            @RequestBody StoreReqDTO.CreateStoreDTO req
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                storeCommandService.createStore(req)
        );
    }

    /**
     * 상점 정보 수정
     */
    @PutMapping("/{storeId}")
    public ApiResponse<Void> updateStore(
            @PathVariable Long storeId,
            @RequestBody StoreReqDTO.UpdateStoreDTO req
    ) {
        storeCommandService.updateStore(storeId, req);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }

    /**
     * 상점 삭제
     */
    @DeleteMapping("/{storeId}")
    public ApiResponse<Void> deleteStore(
            @PathVariable Long storeId
    ) {
        storeCommandService.deleteStore(storeId);
        GeneralSuccessCode code = GeneralSuccessCode.OK;
        return ApiResponse.onSuccess(code, null);
    }

     //8주차 과제: 가게에 리뷰 추가하기 API
     //가게에 리뷰 추가하기
     //로그인 기능 없음 - 하드코딩된 userId 사용 (DB에 있는 임의의 유저)
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.CreateReviewResultDTO> addReviewToStore(
            @PathVariable Long storeId,
            @RequestBody ReviewReqDTO.CreateReviewDTO req
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                reviewCommandService.createReviewForStore(storeId, req)
        );
    }

// 8주차 과제: 미션 도전하기 API
//가게의 미션을 도전 중인 미션에 추가 (미션 도전하기)
//로그인 기능 없음 - 하드코딩된 userId 사용 (DB에 있는 임의의 유저)
    @PostMapping("/{storeId}/missions/{missionId}/challenge")
    public ApiResponse<MissionResDTO.ChallengeMissionResultDTO> challengeMission(
            @PathVariable Long storeId,
            @PathVariable Long missionId
    ) {
        GeneralSuccessCode code = GeneralSuccessCode.CREATED;
        return ApiResponse.onSuccess(
                code,
                missionCommandService.challengeMission(storeId, missionId)
        );
    }
}
