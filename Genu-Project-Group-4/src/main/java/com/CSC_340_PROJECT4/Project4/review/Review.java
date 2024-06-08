package com.CSC_340_PROJECT4.Project4.review;

import com.CSC_340_PROJECT4.Project4.customer.Customer;
import com.CSC_340_PROJECT4.Project4.reply.Reply;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantOwner restaurantOwner;

    private String comment;

    private int rating;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Reply> replies;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
