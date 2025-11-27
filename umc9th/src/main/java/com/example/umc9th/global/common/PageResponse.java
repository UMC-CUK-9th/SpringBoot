package com.example.umc9th.global.common;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResponse<T> {

    private int currentPage;
    private int totalPages;
    private long totalElements;
    private boolean isFirst;
    private boolean isLast;
    private List<T> content;
}
