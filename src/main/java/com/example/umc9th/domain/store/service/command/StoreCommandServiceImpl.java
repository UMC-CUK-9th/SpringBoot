package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.req.StoreReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    public StoreResDTO.CreateStoreResultDTO createStore(StoreReqDTO.CreateStoreDTO req) {
        // 유효성 검사
        if (req.getName() == null || req.getName().isEmpty()) {
            throw new StoreException(StoreErrorCode.STORE_NAME_EMPTY);
        }

        // Store Entity 생성 및 저장
        Store store = Store.builder()
                .name(req.getName())
                .detailAddress(req.getAddress())
                .ownerNumber(Long.parseLong(req.getPhoneNumber()))
                .build();

        Store savedStore = storeRepository.save(store);

        return StoreConverter.toCreateStoreResultDTO(savedStore);
    }

    @Override
    public void updateStore(Long storeId, StoreReqDTO.UpdateStoreDTO req) {
        // 상점 존재 여부 검증
        storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        // 유효성 검사
        if (req.getName() == null || req.getName().isEmpty()) {
            throw new StoreException(StoreErrorCode.STORE_NAME_EMPTY);
        }

        // Store Entity 업데이트 (dirty checking으로 자동 저장)
        // 필요에 따라 Entity에 수정 메서드 추가 가능
        // store.update(req.getName(), req.getAddress(), req.getPhoneNumber());
    }

    @Override
    public void deleteStore(Long storeId) {
        // 상점 존재 여부 검증
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.STORE_NOT_FOUND));

        // Store Entity 삭제
        storeRepository.delete(store);
    }
}
