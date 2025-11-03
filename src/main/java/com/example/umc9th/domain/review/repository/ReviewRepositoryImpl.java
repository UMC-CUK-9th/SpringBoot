package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.restaurant.entity.QRestaurant;
import com.example.umc9th.domain.review.dto.ReviewResponseDto;
import com.example.umc9th.domain.review.entity.QReview;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    // 6주차 미션 - 내가 작성한 리뷰 보기 API (QueryDSL)
    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewResponseDto> findMyReviews(Long memberId, String restaurantName, Integer grade) {
        QReview review = QReview.review;
        QRestaurant restaurant = QRestaurant.restaurant;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.id.eq(memberId));

        // 가게 이름 필터
        if (restaurantName != null && !restaurantName.isEmpty()) {
            builder.and(restaurant.name.eq(restaurantName));
        }

        // 별점대 필터
        if (grade != null) {
            switch (grade) {
                case 5 -> builder.and(review.grade.eq(5));
                case 4 -> builder.and(review.grade.between(4.0, 4.9));
                case 3 -> builder.and(review.grade.between(3.0, 3.9));
                case 2 -> builder.and(review.grade.between(2.0, 2.9));
                case 1 -> builder.and(review.grade.between(1.0, 1.9));
            }
        }

        // 조회 쿼리 (DTO 매핑 + 최신순 정렬)
        return queryFactory
                .select(Projections.constructor(ReviewResponseDto.class,
                        restaurant.name,
                        review.grade,
                        review.comment))
                .from(review)
                .join(review.restaurant, restaurant)
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}