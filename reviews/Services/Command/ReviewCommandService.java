package com.example.demo.domain.reviews.Services.Command;

import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.stores.entity.Stores;
import com.example.demo.domain.users.entity.Users;

public interface ReviewCommandService {
    Reviews createReview(Users user, Stores store, String content, Float rating);
}
