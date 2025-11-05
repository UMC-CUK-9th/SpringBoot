package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.store.entity.QStore;
import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {


    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(EntityManager em) { // 직접 생성자 작성
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Page<Review> findMyReviews(Long userId,
                                      Long storeId,
                                      String storeName,
                                      String ratingBand,
                                      Pageable pageable) {

        QReview review = QReview.review;
        QStore store = QStore.store;

        BooleanBuilder where = new BooleanBuilder()
                .and(review.user.id.eq(userId))
                .and(review.deletedAt.isNull());

        // 가게 필터: id 우선, 없으면 이름
        if (storeId != null) {
            where.and(review.store.id.eq(storeId));
        } else if (storeName != null && !storeName.isBlank()) {
            where.and(review.store.name.eq(storeName));
        }

        // 별점대 필터
        String band = (ratingBand == null ? "ALL" : ratingBand.toUpperCase());
        switch (band) {
            case "FIVE"  -> where.and(review.star.eq(5.0f));
            case "FOUR"  -> where.and(review.star.goe(4.0f).and(review.star.lt(5.0f)));
            case "THREE" -> where.and(review.star.goe(3.0f).and(review.star.lt(4.0f)));
            case "TWO"   -> where.and(review.star.goe(2.0f).and(review.star.lt(3.0f)));
            case "ONE"   -> where.and(review.star.goe(1.0f).and(review.star.lt(2.0f)));
            default -> { /* ALL: no-op */ }
        }

        // 본문 조회 (가게 fetch join으로 N+1 방지)
        List<Review> results = queryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .where(where)
                .orderBy(review.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 카운트 쿼리 (fetchJoin 금지)
        Long total = queryFactory
                .select(review.count())
                .from(review)
                .where(where)
                .fetchOne();

        return new PageImpl<>(results, pageable, total == null ? 0 : total);
    }
}

