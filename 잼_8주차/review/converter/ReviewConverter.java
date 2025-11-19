package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.store.dto.Req.StoreReqDto;
import com.example.umc9th.domain.store.dto.Res.StoreResDto;
import com.example.umc9th.domain.store.entity.Store;

public class ReviewConverter {
    public static ReivewResDto.JoinDTO toJoinDTO(Review review) {
        return ReivewResDto.JoinDTO.builder()
                .storeId(store.getId())
                .userId(user.getId())
                .build();
    }

    // DTO -> Entitiy
    public static Reivew toReview(
            ReviewReqDto.JoinDTO dto
    ){
        return Review.builder()
                .name(dto.name())
                .build();
    }
}
