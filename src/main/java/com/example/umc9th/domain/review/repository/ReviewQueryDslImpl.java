package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.restaurant.entity.QRestaurant;
import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    // JPA 세팅
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> searchReview(
        Predicate predicate
    ){

        // Q클래스 선언
        QReview review = QReview.review;
        QRestaurant restaurant = QRestaurant.restaurant;

        return queryFactory
                .selectFrom(review)
                .leftJoin(review.restaurant, restaurant)
                .where(predicate)
                .fetch();
    }
}