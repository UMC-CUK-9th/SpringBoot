package com.example.demo.domain.reviews.repository;

import com.example.demo.domain.reviews.entity.mapping.ReviewImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewImagesRepository extends JpaRepository<ReviewImages, Long> {
}