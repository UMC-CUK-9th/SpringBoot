package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.umc9th.domain.review.entity.QReview;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    // Q클래스 정의
    private static final QReview review = QReview.review;

    public List<Review> searchReview(String type, String query) {

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // 아무 조건 없으면 전체 조회
        if (type == null || type.isBlank()) {
            return reviewRepository.searchReview(builder);
        }

        String t = type.toLowerCase();

        if ("region_eq".equals(t)) {
            applyRegion(builder, query);
        } else if ("grade_eq".equals(t)) {
            applyGradeExact(builder, query);
        } else if ("both_eq".equals(t)) {
            applyBoth(builder, query);
        } else if ("restaurant".equals(t)) {
            applyRestaurant(builder, query);
        } else if ("grade_band".equals(t)) {
            applyGradeBand(builder, query);
        }

        return reviewRepository.searchReview(builder);
    }

    // 지역명 필터
    private void applyRegion(BooleanBuilder builder, String region) {
        if (isNotBlank(region)) {
            builder.and(review.restaurant.region.eq(region));
        }
    }

    // 별점 필터
    private void applyGradeExact(BooleanBuilder builder, String gradeStr) {
        if (isNotBlank(gradeStr)) {
            try {
                int grade = Integer.parseInt(gradeStr);
                builder.and(review.grade.eq(grade));
            } catch (NumberFormatException ignored) {}
        }
    }

    // 지역명&별점 필터
    private void applyBoth(BooleanBuilder builder, String query) {
        if (!isNotBlank(query)) return;
        String[] parts = query.split("&", 2);

        applyRegion(builder, parts.length > 0 ? parts[0] : null);
        applyGradeExact(builder, parts.length > 1 ? parts[1] : null);
    }

    // 가게 이름 필터
    private void applyRestaurant(BooleanBuilder builder, String name) {
        if (isNotBlank(name)) {
            builder.and(review.restaurant.name.eq(name));
        }
    }

    // 별점대 필터
    private void applyGradeBand(BooleanBuilder builder, String bandStr) {
        if (!isNotBlank(bandStr)) return;

        try {
            int band = Integer.parseInt(bandStr);
            if (band == 5) {
                builder.and(review.grade.eq(5));
            } else if (band >= 1 && band <= 4) {
                builder.and(review.grade.goe(band).and(review.grade.lt(band + 1)));
            }
        } catch (NumberFormatException ignored) {}
    }

    private boolean isNotBlank(String s) {
        return s != null && !s.isBlank();
    }
}