package com.example.umc9th.domain.store.service.query;

import com.example.umc9th.domain.store.dto.res.StoreResDTO;

public interface StoreQueryService {
    StoreResDTO.StoreInfoDTO getStoreInfo(Long storeId);
    StoreResDTO.StoreDetailDTO getStoreDetail(Long storeId);
}
