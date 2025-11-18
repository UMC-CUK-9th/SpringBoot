package com.example.umc9th.domain.region.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class RegionReqDTO {

    @Getter
    @Setter
    @Schema(name = "RegionCreateRequest")
    public static class CreateDTO {

        @NotBlank(message = "지역명은 필수입니다.")
        private String regionName;
    }
}