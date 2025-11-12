package com.example.demo.domain.reviews.repository;

import com.example.demo.domain.reviews.entity.QReviews;
import com.example.demo.domain.reviews.entity.Reviews;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.querydsl.core.types.Predicate;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {
    private final EntityManager em;

    @Override
    public List<Reviews> searchReview(Predicate predicate) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReviews reviews = QReviews.reviews;

        return queryFactory
                .selectFrom(reviews)
                .leftJoin(reviews.stores).fetchJoin()
                .leftJoin(reviews.users).fetchJoin()
                .where(predicate)
                .fetch();
    }
}