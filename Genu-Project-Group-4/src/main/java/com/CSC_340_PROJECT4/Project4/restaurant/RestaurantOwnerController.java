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

    @GetMapping("/{id}")
    public String getRestaurantOwnerById(@PathVariable int id, Model model) {
        RestaurantOwner restaurantOwner = restaurantOwnerService.getRestaurantOwnerById(id);
        model.addAttribute("restaurantOwner", restaurantOwner);
        return "Restaurant/SettingRestaurent"; // Name of the Thymeleaf template
    }

    // Create new Restaurant Owner
    @PostMapping("/create")
    public String createRestaurantOwner(RestaurantOwner restaurantOwner, Model model) {
        RestaurantOwner createdRestaurantOwner = restaurantOwnerService.createRestaurantOwner(restaurantOwner);
        model.addAttribute("Restaurant", createdRestaurantOwner);
        return "redirect:/restaurant-owners/login";  // Go back to the login page for the Restaurant
    }

    @PostMapping("/{id}")
    public String updateRestaurantOwner(@PathVariable int id, RestaurantOwner restaurantOwnerDetails, Model model) {
        RestaurantOwner updatedRestaurantOwner = restaurantOwnerService.updateRestaurantOwner(id, restaurantOwnerDetails);
        model.addAttribute("restaurantOwner", updatedRestaurantOwner);
        return "redirect:/restaurant-owners/owner/" + id;
    }



    @DeleteMapping("/delete/{id}")  // Delete the RestaurantOwner by their id
    public void deleteRestaurantOwner(@PathVariable int id) {
        restaurantOwnerService.deleteRestaurantOwner(id);
    }
}
