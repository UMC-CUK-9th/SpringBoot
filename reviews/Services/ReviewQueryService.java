package com.example.demo.domain.reviews.Services;

import com.example.demo.domain.reviews.entity.Reviews;
import java.util.List;

public interface ReviewQueryService {
    List<Reviews> searchReview(String type, String query);
}
