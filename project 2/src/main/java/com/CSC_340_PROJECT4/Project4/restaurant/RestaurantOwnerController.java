package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant-owners")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @GetMapping("/all")
    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerService.getAllRestaurantOwners();
    }

    @GetMapping("/owner/{id}")
    public RestaurantOwner getRestaurantOwnerById(@PathVariable int id) {
        return restaurantOwnerService.getRestaurantOwnerById(id);
    }

    @PostMapping("/create")
    public RestaurantOwner createRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
        return restaurantOwnerService.createRestaurantOwner(restaurantOwner);
    }

    @PutMapping("/update/{id}")
    public RestaurantOwner updateRestaurantOwner(@PathVariable int id, @RequestBody RestaurantOwner restaurantOwnerDetails) {
        return restaurantOwnerService.updateRestaurantOwner(id, restaurantOwnerDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRestaurantOwner(@PathVariable int id) {
        restaurantOwnerService.deleteRestaurantOwner(id);
    }
}


