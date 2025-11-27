package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.MissionStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(description = "미션 정보 DTO")
public class MissionDto {
    
    @Schema(description = "미션 ID", example = "1")
    private Long missionId;
    
    @Schema(description = "미션 이름", example = "리뷰 5개 작성하기")
    private String missionName;
    
    @Schema(description = "미션 내용", example = "이번 주 리뷰를 5개 작성해보세요!")
    private String missionContent;
    
    @Schema(description = "미션 상태", example = "OPEN")
    private MissionStatus missionStatus;
    
    @Schema(description = "미션 포인트", example = "1000")
    private Integer missionPoint;
    
    @Schema(description = "미션 종료일")
    private LocalDateTime missionEndDate;
    
    @Schema(description = "가게 이름", example = "맥도날드 강남점")
    private String storeName;
    
    @Schema(description = "지역 이름", example = "강남구")
    private String regionName;
    
    @Schema(description = "카테고리", example = "패스트푸드")
    private String category;
    
    @Schema(description = "완료한 미션 개수", example = "3")
    private Long completedMissionCount;
    
    @Schema(description = "사용자 포인트", example = "5000")
    private Long userPoint;
    
    @Schema(description = "D-Day", example = "7")
    private Long dDay;

    // JPQL 생성자 표현식을 위한 생성자 (MissionRepository에서 사용)
    public MissionDto(String regionName, Long userPoint, Long completedMissionCount,
                      Long missionId, String storeName, String category,
                      String missionContent, Integer missionPoint,
                      MissionStatus missionStatus, Long dDay) {
        this.regionName = regionName;
        this.userPoint = userPoint;
        this.completedMissionCount = completedMissionCount;
        this.missionId = missionId;
        this.storeName = storeName;
        this.category = category;
        this.missionContent = missionContent;
        this.missionPoint = missionPoint;
        this.missionStatus = missionStatus;
        this.dDay = dDay;
        this.missionName = null;
        this.missionEndDate = null;
    }

    // 빌더용 전체 생성자
    public MissionDto(Long missionId, String missionName, String missionContent,
                      MissionStatus missionStatus, Integer missionPoint,
                      LocalDateTime missionEndDate, String storeName,
                      String regionName, String category, Long completedMissionCount,
                      Long userPoint, Long dDay) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionContent = missionContent;
        this.missionStatus = missionStatus;
        this.missionPoint = missionPoint;
        this.missionEndDate = missionEndDate;
        this.storeName = storeName;
        this.regionName = regionName;
        this.category = category;
        this.completedMissionCount = completedMissionCount;
        this.userPoint = userPoint;
        this.dDay = dDay;
    }
}
