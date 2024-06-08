package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


/**
 * Controller class it handle requests related to Restaurant Owners.
 */

@Controller
@RequestMapping("/restaurant-owners")
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    @GetMapping("/all")  // List all restaurant owners.
    public List<RestaurantOwner> getAllRestaurantOwners() {
        return restaurantOwnerService.getAllRestaurantOwners();
    }

    // it Return restaurant owner by their ID.

    @GetMapping("/owner/{id}")
    public RestaurantOwner getRestaurantOwnerById(@PathVariable int id) {
        return restaurantOwnerService.getRestaurantOwnerById(id);
    }

    // Create new Restaurant Owner
    @PostMapping("/create")
    public String createRestaurantOwner(RestaurantOwner restaurantOwner, Model model) {
        RestaurantOwner createdRestaurantOwner = restaurantOwnerService.createRestaurantOwner(restaurantOwner);
        model.addAttribute("Restaurant", createdRestaurantOwner);
        return "redirect:/restaurant/login";  // Go back to the login page for the Restaurant
    }

    @PutMapping("/update/{id}")  // Update the ResturantOwner by their id
    public RestaurantOwner updateRestaurantOwner(@PathVariable int id, @RequestBody RestaurantOwner restaurantOwnerDetails) {
        return restaurantOwnerService.updateRestaurantOwner(id, restaurantOwnerDetails);
    }

    @DeleteMapping("/delete/{id}")  // Delete the RestaurantOwner by their id
    public void deleteRestaurantOwner(@PathVariable int id) {
        restaurantOwnerService.deleteRestaurantOwner(id);
    }
}
