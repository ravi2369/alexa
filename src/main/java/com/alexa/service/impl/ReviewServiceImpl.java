package com.alexa.service.impl;

import com.alexa.model.Review;
import com.alexa.repository.ReviewRepository;
import com.alexa.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review data) {
        Review review = Review.builder()
                .id(System.nanoTime()).build();
        data.setId(review.getId());
        return reviewRepository.save(data);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsByRating(Float rating) {
        List<Review> reviews = reviewRepository.findAll();
        List<Review> reviewList = new ArrayList<>();
        for (Review review : reviews) {
            if (rating.equals(review.getRating())) {
                List<Review> reviewsList = new ArrayList<>();
                reviewsList.add(review);
                reviewList.addAll(reviewsList);
            }
        }
        return reviewList;
    }
}
