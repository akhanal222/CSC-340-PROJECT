package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantSearchService {
    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    public List<RestaurantOwner> searchRestaurants(String query, String type, int minRating) {  // Search Restaurants using filter for the Cusrtomer
        return restaurantOwnerRepository.findAll().stream()
                .filter(restaurant -> restaurant.getRestaurantName().toLowerCase().contains(query.toLowerCase()) ||
                        restaurant.getRestaurantAddress().toLowerCase().contains(query.toLowerCase()))
                .filter(restaurant -> type == null || restaurant.getRestaurantType().equalsIgnoreCase(type))
                .filter(restaurant -> minRating <= 0 || restaurant.getAverageRating() >= minRating)
                .collect(Collectors.toList());
    }
}
