package com.example.umc9th.domain.review.service;
//import com.example.umc9th.domain.review.*;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
//import com.example.umc9th.domain.user.*;
//import com.example.umc9th.domain.store.*;
import com.example.umc9th.domain.review.repository.*;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.*;
import com.example.umc9th.domain.store.repository.*;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.example.umc9th.domain.store.entity.QStore.store;
import static com.example.umc9th.domain.user.entity.QUser.user;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final EntityManager em;

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final QReview review = QReview.review;

    @Transactional
    public Review writeReview(Long storeId, Long userId, int star, String detail) {
        User user = userRepository.findById(userId).orElseThrow();
        Store store = storeRepository.findById(storeId).orElseThrow();

//        Review review = new Review(user, store, star, detail);
//        review.setUser(user);
//        review.setStore(store);
//        review.setStar(star);
//        review.setDetail(detail);

        Review review = Review.builder()
                .user(user)
                .store(store)
                .star(star)
                .detail(detail)
                .build();

        return reviewRepository.save(review);

    }

    public List<Review> getReviewsByStoreId(Long storeId) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .selectFrom(review)
                .leftJoin(review.store, store).fetchJoin()
                .leftJoin(review.user, user).fetchJoin()
                .where(
                        review.store.id.eq(storeId)
//                        ,minStar != null ? review.star.goe(minStar) : null // 별점 필터
                )
                .orderBy(review.id.desc())
                .fetch();
    }

    public Double getAverageStar(Long storeId) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .select(review.star.avg())          // 평균 별점
                .from(review)
                .where(review.store.id.eq(storeId)) // 가게 ID 조건
                .fetchOne();
    }
}
