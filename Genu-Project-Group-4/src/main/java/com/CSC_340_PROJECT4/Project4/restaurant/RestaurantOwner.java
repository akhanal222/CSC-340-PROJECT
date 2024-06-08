package com.CSC_340_PROJECT4.Project4.restaurant;

import com.CSC_340_PROJECT4.Project4.user.User;
import jakarta.persistence.Entity;
import org.springframework.lang.NonNull;

@Entity
public class RestaurantOwner extends User {

    @NonNull
    private String email; // Email of the Restaurant

    @NonNull
    private String restaurantName; // Name of the Restaurant

    @NonNull
    private String restaurantAddress; // Address of the restaurant

    @NonNull
    private String restaurantPhoneNumber; // Phone Number of the restaurant

    @NonNull
    private String restaurantType; // Type of the restaurant

    @NonNull
    private String Password; // Password for the Restaurant account

    public RestaurantOwner() {

    }

    public RestaurantOwner(@NonNull String email, @NonNull String restaurantName, @NonNull String restaurantAddress, @NonNull String restaurantPhoneNumber, @NonNull String restaurantType,String Password) {
        this.email = email;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantType = restaurantType;
        this.Password= Password;
    }


    @NonNull
    public String getPassword() {
        return Password;
    }
    public void setPassword(@NonNull String password) {
        Password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
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
