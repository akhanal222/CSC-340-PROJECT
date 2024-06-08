package com.CSC_340_PROJECT4.Project4.review;

public class ReplyDTO {
    private int reviewId;
    private int restaurantOwnerId;
    private String comment;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRestaurantOwnerId() {
        return restaurantOwnerId;
    }

    public void setRestaurantOwnerId(int restaurantOwnerId) {
        this.restaurantOwnerId = restaurantOwnerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
