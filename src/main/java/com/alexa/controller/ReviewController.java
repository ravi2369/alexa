package com.alexa.controller;

import com.alexa.model.Review;
import com.alexa.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alexa.util.URI.*;

@RestController
@RequestMapping(ALEXA + VERSION)
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping(REVIEW)
    public Review createReview(@RequestBody Review review) {
        return reviewService.save(review);
    }

    @GetMapping(ALL_REVIEWS)
    public List<Review> createReview() {
        return reviewService.getAllReviews();
    }

    @GetMapping(REVIEW_BY_RATING)
    public List<Review> getReviewByRating(@RequestParam String rating) {
        return reviewService.getReviewsByRating(Float.parseFloat(rating));
    }
}
