package com.CSC_340_PROJECT4.Project4.customer;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/home")
    public String viewHomepage() {
        return "HTML/First page";  // home page
    }

    @GetMapping("/customer/signup")
    public String customerSignUp(Model model) {
        model.addAttribute("customer", new Customer());
        return "Customer/CustomerSinup";            // customer Signup
    }

    @GetMapping("/customer/login")
    public String customerLogin() {                 // Customer login
        return "Customer/Customerslogin";
    }

    @GetMapping("/restaurant/login")
    public String restaurantLogin() {               // Restaurant login
        return "Restaurant/Restaurantlogin";
    }

    @GetMapping("/restaurant/signup")
    public String restaurantSignUp(Model model) {    // Restaurant login
        model.addAttribute("restaurantOwner", new RestaurantOwner());
        return "Restaurant/restaurantsinup";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {  // admin login
        return "Admin/AdminLogin";
    }
}
