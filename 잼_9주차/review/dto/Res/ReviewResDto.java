package com.example.umc9th.domain.review.dto.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDto {

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

//    static class로 목록 조회 DTO
//    @Builder
//    @Getter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class ReviewPreViewListDTO {
//        ReviewPreViewDTO reviewList;
//        Integer listSize;
//        Integer totalPage;
//        Long totalElements;
//        Boolean isFirst;
//        Boolean isLast;
//    }

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ){}

//    추가, 수정, 삭제 DTO 생성하기


    @Builder
    public record JoinDTO(
            Long storeId,
            Long userId,
            String content,
            Float star,
            LocalDateTime createdAt
    ){}
}
