package com.alexa.service;

import com.alexa.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    List<Review> getAllReviews();
    List<Review> getReviewsByRating(Float rating);
}
