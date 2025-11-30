package com.example.umc9th.domain.review.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReviewRequest {

    private Long storeId;
    private Double favorite;
    private String content;
    private List<String> reviewImgUrls;
}
