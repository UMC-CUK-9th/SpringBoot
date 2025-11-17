package com.example.umc9th.domain.mission.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 8주차 미션 - 3. 가게에 미션 추가하기 API
public class MissionReqDTO {

    @Getter
    @Setter
    @Schema(name = "MissionCreateRequest")
    public static class CreateDTO {
        @NotBlank(message = "미션 내용은 필수입니다.")
        @Size(max = 100, message = "미션 내용은 100자 이하여야 합니다.")
        private String content;

        @NotNull(message = "마감 기한은 필수입니다.")
        @Future(message = "마감 기한은 현재 시각 이후여야 합니다.")
        private LocalDateTime deadline;

        @NotNull(message = "최소 금액은 필수입니다.")
        @Positive(message = "최소 금액은 0보다 커야 합니다.")
        private long price;

        @NotNull(message = "포인트는 필수입니다.")
        @Positive(message = "포인트는 0보다 커야 합니다.")
        private long point;
    }
}