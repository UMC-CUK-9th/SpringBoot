package com.example.demo.domain.missions.dto;

import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionsReqDto {
    private Long memberId;
    private Long missionId;
}
