package com.CSC_340_PROJECT4.Project4.reply;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import com.CSC_340_PROJECT4.Project4.review.Review;
import jakarta.persistence.*;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "restaurant_owner_id")
    private RestaurantOwner restaurantOwner;

    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public RestaurantOwner getRestaurantOwner() {
        return restaurantOwner;
    }

    public void setRestaurantOwner(RestaurantOwner restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
