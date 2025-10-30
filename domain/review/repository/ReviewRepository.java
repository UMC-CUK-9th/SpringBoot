package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.mission.dto.UserMissionDto;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;

public interface ReviewRepository extends JpaRepository<Review,Long>{
    @Query("SELECT r FROM Review r JOIN FETCH r.user WHERE r.store.id = :storeID ORDER BY r.id DESC")
    List<Review> findByStoreID(@Param("storeID") Long storeID);

    @Query("SELECT AVG(r.star) FROM Review r WHERE r.store.id = :storeID")
    Double findAverageStarByStoreId(@Param("storeID") Long storeID);


    @Query("SELECT new com.example.umc9th.domain.mission.dto.UserMissionDto(um.id, um.user.id, um.mission.id) " +
            "FROM UserMission um " +
            "JOIN um.mission m " +
            "JOIN m.store s " +
            "JOIN s.location l " +
            "ORDER BY um.id DESC")
    List<UserMissionDto> findLatestUserMission(Pageable pageable);
}
