package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;

public class StoreConverter {

    // Store Entity -> 기본 정보 DTO 변환
    public static StoreResDTO.StoreInfoDTO toStoreInfoDTO(Store store) {
        return StoreResDTO.StoreInfoDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getDetailAddress())
                .phoneNumber(store.getOwnerNumber().toString())
                .build();
    }

    // Store Entity -> 상세 정보 DTO 변환
    public static StoreResDTO.StoreDetailDTO toStoreDetailDTO(Store store) {
        return StoreResDTO.StoreDetailDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getDetailAddress())
                .phoneNumber(store.getOwnerNumber().toString())
                .status("ACTIVE")
                .build();
    }

    // Store Entity -> 생성 결과 DTO 변환
    public static StoreResDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .build();
    }
}
