package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.Req.ReviewReqDto;
import com.example.umc9th.domain.review.dto.Res.ReviewResDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.dto.Req.StoreReqDto;
import com.example.umc9th.domain.store.dto.Res.StoreResDto;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {
    public static ReviewResDto.JoinDTO toJoinDTO(Review review) {
        return ReviewResDto.JoinDTO.builder()
                .storeId(store.getId())
                .userId(user.getId())
                .build();
    }

    // DTO -> Entity
    public static Review toReview(
            ReviewReqDto.JoinDTO dto
    ){
        return Review.builder()
                .name(dto.name())
                .build();
    }

    // result -> DTO
    public static ReviewResDto.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDto.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDto.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDto.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getStar())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }
}
