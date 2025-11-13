package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;

public interface StoreCommandService {
    StoreResDTO.CreateStoreResultDTO createStore(StoreReqDTO.CreateStoreDTO req);
    void updateStore(Long storeId, StoreReqDTO.UpdateStoreDTO req);
    void deleteStore(Long storeId);
}
