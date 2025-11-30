package com.example.umc9th.domain.region.dto.res;

import lombok.Builder;
import lombok.Getter;

public class RegionResDTO {

    @Getter
    @Builder
    public static class CreateDTO {
        private Long regionId;
        private String regionName;
    }
}