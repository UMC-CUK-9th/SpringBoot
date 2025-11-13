package com.example.umc9th.domain.store.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreReqDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateStoreDTO {
        private String name;
        private String address;
        private String phoneNumber;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateStoreDTO {
        private String name;
        private String address;
        private String phoneNumber;
    }
}
