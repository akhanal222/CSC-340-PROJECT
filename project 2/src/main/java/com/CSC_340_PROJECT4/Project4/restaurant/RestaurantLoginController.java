package com.CSC_340_PROJECT4.Project4.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantLoginController {

    @GetMapping("/restaurant/login")
    public String restaurantLogin() {
        return "Restaurant/Restaurantlogin";
    }

    // login page for the restaurant
}
