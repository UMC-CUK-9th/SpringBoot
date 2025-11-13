package com.example.umc9th.domain.store.controller;

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
}
