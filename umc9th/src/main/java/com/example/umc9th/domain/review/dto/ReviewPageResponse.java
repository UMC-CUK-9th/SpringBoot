package com.example.umc9th.domain.review.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReviewPageResponse {
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<ReviewResponse> reviews;
}
