package com.example.demo.domain.reviews.Services;

import com.example.demo.domain.reviews.dto.ReviewsResponseDto;
import com.example.demo.domain.reviews.entity.Reviews;
import com.example.demo.domain.reviews.repository.ReviewsRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.domain.reviews.entity.QReviews.reviews;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewsRepository reviewsRepository;

    public List<ReviewsResponseDto> searchReview(String type, String query) {

        BooleanBuilder builder = new BooleanBuilder();

        if (type.equals("rating")) {
            builder.and(reviews.rating.goe(3.0F).and(reviews.rating.lt(5.0F)));
        } else if (type.equals("store_name")) {
            builder.and(reviews.stores.name.eq(query));
        } else if (type.equals("both")) {
            String storeNameQuery = query.split("&")[0];
            String ratingString = query.split("&")[1];
            Float ratingValue = Float.parseFloat(ratingString);

            builder.and(reviews.stores.name.eq(storeNameQuery));

            if (ratingValue == 3.0F) {
                builder.and(reviews.rating.goe(3.0F).and(reviews.rating.lt(4.0F)));
            } else if (ratingValue == 4.0F) {
                builder.and(reviews.rating.goe(4.0F).and(reviews.rating.lt(5.0F)));
            } else if (ratingValue == 5.0F) {
                builder.and(reviews.rating.goe(5.0F));
            }
        }

        // 검색 후 DTO로 변환
        List<Reviews> results = reviewsRepository.searchReview(builder);

        return results.stream()
                .map(r -> ReviewsResponseDto.builder()
                        .id(r.getReviewId())
                        .content(r.getContent())
                        .rating(r.getRating())
                        .storeName(r.getStores().getName())
                        .build())
                .collect(Collectors.toList());
    }
}
