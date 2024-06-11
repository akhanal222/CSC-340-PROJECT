package com.CSC_340_PROJECT4.Project4;

import com.CSC_340_PROJECT4.Project4.customer.Customer;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/home")
    public String viewHomepage() {
        return "/HTML/First page";  // home page
    }

    @GetMapping("/login")
    public String login() {
        return "/HTML/login";  // home page
    }


    // add resturent login

    @GetMapping("/restaurant-owners/login")
    public String restaurantLogin() {               // Restaurant login
        return "Restaurant/Restaurantlogin";
    }

    @GetMapping("/restaurant-owners/signup")
    public String restaurantSignUp(Model model) {    // Restaurant login
        model.addAttribute("restaurantOwner", new RestaurantOwner());
        return "Restaurant/RestaurantSinup";
    }

    // add customer login

    @GetMapping("/customer/signup") // Show customer signup form
    public String customerSignUp(Model model) {
        model.addAttribute("customer", new Customer());
        return "Customer/CustomerSinup"; // customer signup page
    }

    @GetMapping("/customer/login")
    public String customerLogin() {                 // Customer login
        return "Customer/Customerslogin";
    }

//     add admin login

    @GetMapping("/admin/login")
    public String adminLogin() {  // admin login
        return "Admin/AdminLogin";
    }
}

