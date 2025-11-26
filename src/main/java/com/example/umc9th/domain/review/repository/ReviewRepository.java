package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    // 9주차 미션 - 내가 작성한 리뷰 목록 조회 (페이징)
    Page<Review> findAllByUserId(Long userId, PageRequest pageRequest);
}
