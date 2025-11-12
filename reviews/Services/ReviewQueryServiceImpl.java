package com.example.demo.domain.reviews.Services;

import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.domain.reviews.entity.QReviews.reviews;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewsRepository reviewsRepository;

    @Override
    public List<Reviews> searchReview(String type, String query) {
        BooleanBuilder builder = new BooleanBuilder();

        switch (type) {
            case "rating" -> builder.and(reviews.rating.goe(3.0F).and(reviews.rating.lt(5.0F)));
            case "store_name" -> builder.and(reviews.stores.name.eq(query));
            case "both" -> {
                String[] parts = query.split("&");

                String storeName = parts[0];
                Float rating = Float.parseFloat(parts[1]);

                builder.and(reviews.stores.name.eq(storeName));
                if (rating == 3.0F) builder.and(reviews.rating.between(3.0F, 3.99F));
                else if (rating == 4.0F) builder.and(reviews.rating.between(4.0F, 4.99F));
                else if (rating == 5.0F) builder.and(reviews.rating.goe(5.0F));
            }
        }

        return reviewsRepository.searchReview(builder);
    }
}
