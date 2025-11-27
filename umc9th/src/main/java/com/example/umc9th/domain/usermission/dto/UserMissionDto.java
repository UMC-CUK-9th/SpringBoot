package com.example.umc9th.domain.usermission.dto;

import com.example.umc9th.domain.usermission.entity.UserMissionStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(description = "사용자 미션 정보 DTO")
public class UserMissionDto {
    
    @Schema(description = "사용자 미션 ID", example = "1")
    private Long userMissionId;
    
    @Schema(description = "미션 ID", example = "1")
    private Long missionId;
    
    @Schema(description = "미션 이름", example = "리뷰 5개 작성하기")
    private String missionName;
    
    @Schema(description = "미션 내용", example = "이번 주 리뷰를 5개 작성해보세요!")
    private String missionContent;
    
    @Schema(description = "미션 포인트", example = "1000")
    private Integer missionPoint;
    
    @Schema(description = "가게 이름", example = "맥도날드 강남점")
    private String storeName;
    
    @Schema(description = "사용자 미션 상태", example = "ING")
    private UserMissionStatus userMissionStatus;
    
    @Schema(description = "미션 시작일")
    private LocalDateTime userMissionStartedAt;
    
    @Schema(description = "미션 종료일")
    private LocalDateTime missionEndDate;
    
    @Schema(description = "지역 이름", example = "강남구")
    private String regionName;
}
