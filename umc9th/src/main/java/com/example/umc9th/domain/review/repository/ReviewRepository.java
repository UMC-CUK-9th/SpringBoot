package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.mission.dto.MissionDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;

public interface ReviewRepository extends JpaRepository<Review,Long>{
//    @Query("SELECT r FROM Review r JOIN FETCH r.user WHERE r.store.id = :storeID ORDER BY r.id DESC")
//    List<Review> findByStoreID(@Param("storeID") Long storeID);
//
//    @Query("SELECT AVG(r.star) FROM Review r WHERE r.store.id = :storeID")
//    Double findAverageStarByStoreId(@Param("storeID") Long storeID);
//
//    @Query("SELECT new com.example.umc9th.domain.mission.dto.MissionDto(um.id, um.user.id, um.mission.id) " +
//            "FROM UserMission um " +
//            "JOIN um.mission m " +
//            "JOIN m.store s " +
//            "JOIN s.location l " +
//            "ORDER BY um.id DESC")
//    )
//    List<Review> searchReviewByLocation(@Param("star") Float star);

    // 지역만 조회
    @Query(
    value = "SELECT r1 .* " +
            "FROM review r1 " +
            "LEFT JOIN store s1 ON r1.store_id = s1.id " +
            "LEFT JOIN location l1 on s1. location_id = l1.id " +
            "WHERE 11.name LIKE CONCAT('%', :name, '%')", nativeQuery = true
    )
    List<Review> searchReviewByLocation(@Param("name") String name);

    // 별점만 조회
    @Query(
            value = "SELECT r1 .* " +
                "FROM review r1 " +
                "LEFT JOIN store s1 ON r1.store_id = s1.id " +
                "LEFT JOIN location l1 on s1. location_id = l1.id " +
                "WHERE r1.star > :star ", nativeQuery = true
    )
    List<Review> searchReviewByLocation(@Param("star") Float star);

    // 지역 + 별점 조회
    @Query(
        value = "SELECT r1 .* " +
                "FROM review r1 " +
                "LEFT JOIN store s1 ON r1.store_id = s1.id " +
                "LEFT JOIN Location l1 on s1. location_id = l1.id " +
                "WHERE 11.name LIKE CONCAT('%' , :name, '%' ) " +
                "AND r1.star > :star ", nativeQuery = true
    )
    List<Map<String, Object>> searchReviewByLocation(@Param("name") String name, @Param("star") Float star);

    List<Review> searchReview(Long userId, String storeName, String locationName, Integer star);
}