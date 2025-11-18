package com.example.umc9th.domain.restaurant.dto.req;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

// 8주차 미션 - 1. 특정 지역에 가게 추가하기 API
public class RestaurantReqDTO {

    @Getter
    @Setter
    public static class CreateRestDTO {
        @NotBlank(message = "가게 이름은 필수입니다.")
        @Size(max = 20, message = "가게 이름은 20자 이하여야 합니다.")
        private String restName;

        @NotBlank(message = "주소는 필수입니다.")
        private String address;

        @NotBlank(message = "카테고리는 필수입니다.")
        private String category;

        @Size(max = 20, message = "사업자 번호/연락처는 20자 이하여야 합니다.")
        private String ownerNumber;
    }
}