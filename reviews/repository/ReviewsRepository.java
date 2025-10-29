package com.example.demo.domain.reviews.repository;

import com.example.demo.domain.reviews.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}