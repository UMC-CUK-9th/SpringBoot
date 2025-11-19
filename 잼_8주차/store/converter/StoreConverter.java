package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.store.dto.Req.StoreReqDto;
import com.example.umc9th.domain.store.dto.Res.StoreResDto;
import com.example.umc9th.domain.store.entity.Store;

public class StoreConverter {
    public static StoreResDto.JoinDTO toJoinDTO(Store store) {
        return StoreResDto.JoinDTO.builder()
                .storeId(store.getId())
                .build();
    }

    // DTO -> Entitiy
    public static Store toStore(
            StoreReqDto.JoinDTO dto
    ){
        return Store.builder()
                .name(dto.name())
                .build();
    }
}
