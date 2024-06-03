package com.CSC_340_PROJECT4.Project4.restaurant;

import com.CSC_340_PROJECT4.Project4.user.User;

import jakarta.persistence.Entity;
import org.springframework.lang.NonNull;

@Entity
public class RestaurantOwner extends User {

    @NonNull
    private String restaurantName;

    @NonNull
    private String restaurantAddress;

    @NonNull
    private String restaurantPhoneNumber;

    @NonNull
    private String restaurantType;

    private double averageRating;

    @NonNull
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(@NonNull String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @NonNull
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(@NonNull String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    @NonNull
    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(@NonNull String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    @NonNull
    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(@NonNull String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
