package com.example.umc9th.domain.store.dto.res;

import lombok.Builder;
import lombok.Getter;

public class StoreResDTO {

    @Builder
    @Getter
    public static class StoreInfoDTO {
        private Long id;
        private String name;
        private String address;
        private String phoneNumber;
    }

    @Builder
    @Getter
    public static class StoreDetailDTO {
        private Long id;
        private String name;
        private String address;
        private String phoneNumber;
        private String status;
    }

    @Builder
    @Getter
    public static class CreateStoreResultDTO {
        private Long storeId;
        private String name;
    }
}
