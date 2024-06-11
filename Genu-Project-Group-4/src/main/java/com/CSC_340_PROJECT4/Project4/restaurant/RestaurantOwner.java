package com.CSC_340_PROJECT4.Project4.restaurant;

import com.CSC_340_PROJECT4.Project4.user.User;
import jakarta.persistence.Entity;
import org.springframework.lang.NonNull;

@Entity
public class RestaurantOwner extends User {

    @NonNull
    private String restaurantName; // Name of the Restaurant

    @NonNull
    private String restaurantAddress; // Address of the restaurant

    @NonNull
    private String restaurantPhoneNumber; // Phone Number of the restaurant

    @NonNull
    private String restaurantType; // Type of the restaurant

    public RestaurantOwner() {
        super();
    }

    public RestaurantOwner(@NonNull String username, @NonNull String email, @NonNull String password, @NonNull String restaurantName, @NonNull String restaurantAddress, @NonNull String restaurantPhoneNumber, @NonNull String restaurantType, @NonNull String role) {
        super.setUsername(username);
        super.setEmail(email);
        super.setPassword(password);
        super.setRole(role);
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantType = restaurantType;
    }

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
}
