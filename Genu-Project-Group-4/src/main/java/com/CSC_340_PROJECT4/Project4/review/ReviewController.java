package com.CSC_340_PROJECT4.Project4.review;

import com.CSC_340_PROJECT4.Project4.customer.Customer;
import com.CSC_340_PROJECT4.Project4.customer.CustomerRepository;
import com.CSC_340_PROJECT4.Project4.reply.Reply;
import com.CSC_340_PROJECT4.Project4.reply.ReplyService;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    @Autowired
    private ReplyService replyService;

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "Restaurant/ReviewReply";
    }

    @GetMapping("/write")
    public String writeReviewForm(Model model) {
        model.addAttribute("reviewDTO", new ReviewDTO());
        return "Customer/Review"; // Show template for writing reviews
    }

    @PostMapping("/create")
    @ResponseBody
    public Review createReview(@RequestBody ReviewDTO reviewDTO) {
        Optional<Customer> customer = customerRepository.findById(reviewDTO.getCustomerId());
        Optional<RestaurantOwner> restaurantOwner = restaurantOwnerRepository.findById(reviewDTO.getRestaurantId());

        if (customer.isPresent() && restaurantOwner.isPresent()) {
            Review review = new Review();
            review.setCustomer(customer.get());
            review.setRestaurantOwner(restaurantOwner.get());
            review.setComment(reviewDTO.getComment());
            review.setRating(reviewDTO.getRating());

            return reviewService.createReview(review);
        } else {
            throw new RuntimeException("Invalid customer or restaurant ID");
        }
    }

    @PostMapping("/reply")
    public String createReply(@ModelAttribute ReplyDTO replyDTO, Model model) {
        Optional<Review> review = reviewService.getReviewById(replyDTO.getReviewId());
        Optional<RestaurantOwner> restaurantOwner = restaurantOwnerRepository.findById(replyDTO.getRestaurantOwnerId());

        if (review.isPresent() && restaurantOwner.isPresent()) {
            Reply reply = new Reply();
            reply.setReview(review.get());
            reply.setRestaurantOwner(restaurantOwner.get());
            reply.setComment(replyDTO.getComment());

            replyService.createReply(reply);

            return "redirect:/reviews/all"; // Redirect to the reviews page after submitting the reply
        } else {
            model.addAttribute("error", "Invalid review or restaurant owner ID");
            return "reply"; // Return to the reply page with an error message
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}
