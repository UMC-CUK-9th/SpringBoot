package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.global.common.PageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public class ReviewConverter {

    public static PageResponse<ReviewResponse> toPageResponse(Page<Review> page) {
        List<ReviewResponse> reviewResponseList = page.getContent().stream()
                .map(r -> ReviewResponse.builder()
                        .id(r.getId())
                        .content(r.getReviewContent())
                        .favorite(r.getFavorite())
                        .storeName(r.getStore() != null ? r.getStore().getStoreName() : null)
                        .build())
                .toList();

        return PageResponse.<ReviewResponse>builder()
                .currentPage(page.getNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .content(reviewResponseList)
                .build();
    }
}
