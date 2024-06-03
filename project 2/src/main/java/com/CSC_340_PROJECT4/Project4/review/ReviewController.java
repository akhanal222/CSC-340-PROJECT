package com.CSC_340_PROJECT4.Project4.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all") // retuen all
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping("/create") // create all
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @DeleteMapping("/delete/{id}") // delete the review by id
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}
