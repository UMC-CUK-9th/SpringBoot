package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.restaurant.entity.Restaurant;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 9주차 실습 - 가게의 리뷰 목록 조회하기 API (특정 가게의 리뷰를 페이징 조회)
    Page<Review> findAllByRestaurant(Restaurant restaurant, Pageable pageable);

    // 9주차 미션 - 1. 내가 작성한 리뷰 목록 조회하기 API (특정 회원의 리뷰를 페이징 조회)
    Page<Review> findAllByMember(Member member, Pageable pageable);
}

/*
public interface ReviewRepository extends JpaRepository<Review,Long>, ReviewQueryDsl {

    // 5주차 실습 - JPQL를 사용한 리뷰 검색 기능(지역 및 별점 조회)
    // 지역만 조회
    @Query(
            value = "SELECT r1.* " +
                    "FROM review r1 " +
                    "LEFT JOIN store s1 ON r1.store_id = s1.id " +
                    "LEFT JOIN location l1 ON s1.location_id = l1.id " +
                    "WHERE l1.name LIKE CONCAT('%', :name, '%')", nativeQuery = true
    )
    List<Review> searchReviewsByLocation(@Param("name") String name);

    // 별점만 조회
    @Query(
            value = "SELECT r1.* " +
                    "FROM review r1 " +
                    "LEFT JOIN store s1 ON r1.store_id = s1.id " +
                    "LEFT JOIN location l1 ON s1.location_id = l1.id " +
                    "WHERE r1.star > :star", nativeQuery = true
    )
    List<Review> searchReviewsByStar(@Param("star") Float star);

    // 지역 + 별점 조회
    @Query(
            value = "SELECT r1.* " +
                    "FROM review r1 " +
                    "LEFT JOIN store s1 ON r1.store_id = s1.id " +
                    "LEFT JOIN location l1 ON s1.location_id = l1.id " +
                    "WHERE l1.name LIKE CONCAT('%', :name, '%') " +
                    "AND r1.star > :star", nativeQuery = true
    )
    List<Review> searchReviewsByLocationAndStar(@Param("name") String name, @Param("star") Float star);
}
*/