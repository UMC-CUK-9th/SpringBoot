package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {
    @Query("SELECT r FROM Review r JOIN FETCH r.user WHERE r.store.id = :storeID ORDER BY r.id DESC")
    Optional<Store> findStoreWithReviews(@Param("storeID") Long storeID);
}
