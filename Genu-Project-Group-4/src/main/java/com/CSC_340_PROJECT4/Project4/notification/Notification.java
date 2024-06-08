package com.CSC_340_PROJECT4.Project4.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private int userId;

    @NonNull
    private int restaurantId;

    private LocalDateTime reservationTime;

    @NonNull
    private String notificationType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public int getUserId() {
        return userId;
    }

    public void setUserId(@NonNull int userId) {
        this.userId = userId;
    }

    @NonNull
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(@NonNull int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    @NonNull
    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(@NonNull String notificationType) {
        this.notificationType = notificationType;
    }

}
