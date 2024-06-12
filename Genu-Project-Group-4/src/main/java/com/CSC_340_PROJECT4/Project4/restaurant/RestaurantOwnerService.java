
package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantOwnerService {

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerRepository.findAll();
    }

    public RestaurantOwner getRestaurantOwnerById(int id) {
        Optional<RestaurantOwner> optionalRestaurantOwner = restaurantOwnerRepository.findById(id);
        return optionalRestaurantOwner.orElse(null);
    }

    public RestaurantOwner createRestaurantOwner(RestaurantOwner restaurantOwner) {
        if(restaurantOwnerRepository.findByUsername(restaurantOwner.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username already exist");
        }
        restaurantOwner.setPassword((restaurantOwner.getPassword()));
        restaurantOwner.setRole("RESTAURANT");
        return restaurantOwnerRepository.save(restaurantOwner); // create new restuantowner
    }

    // Update the info of the Restaurant
    public RestaurantOwner updateRestaurantOwner(int id, RestaurantOwner restaurantOwnerDetails) {
        Optional<RestaurantOwner> optionalRestaurantOwner = restaurantOwnerRepository.findById(id);
        if (optionalRestaurantOwner.isPresent()) {
            RestaurantOwner existingRestaurantOwner = optionalRestaurantOwner.get();
            existingRestaurantOwner.setRestaurantName(restaurantOwnerDetails.getRestaurantName());
            existingRestaurantOwner.setRestaurantAddress(restaurantOwnerDetails.getRestaurantAddress());
            existingRestaurantOwner.setRestaurantPhoneNumber(restaurantOwnerDetails.getRestaurantPhoneNumber());
            return restaurantOwnerRepository.save(existingRestaurantOwner);
        }
        return null;
    }

    public void deleteRestaurantOwner(int id) {  // delete Resturant by id
        restaurantOwnerRepository.deleteById(id);
    }
}


