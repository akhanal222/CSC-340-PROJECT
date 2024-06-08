package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Let user search Restaurant by using filter **/
@Service
public class RestaurantSearchService {
    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

}
