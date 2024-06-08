package com.CSC_340_PROJECT4.Project4.reservation;

import com.CSC_340_PROJECT4.Project4.customer.Customer;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantOwner restaurantOwner;

    private LocalDateTime reservationTime; // Time for the reservation

    private LocalDate reservationDate; // Date for the reservation

    @NonNull
    private int numberOfGuests; // Number of guest in the reservation


    public LocalDate getReservationDate() {
        return reservationDate;
    }
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

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }


    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

}
