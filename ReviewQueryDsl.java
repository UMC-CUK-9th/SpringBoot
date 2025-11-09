package com.example.demo.domain.reviews.repository;

import com.example.demo.domain.reviews.entity.Reviews;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {
    List<Reviews> searchReview(Predicate predicate);
}