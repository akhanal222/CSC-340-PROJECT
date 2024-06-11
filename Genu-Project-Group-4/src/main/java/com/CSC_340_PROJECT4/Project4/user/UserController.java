package com.CSC_340_PROJECT4.Project4.user;

import com.CSC_340_PROJECT4.Project4.customer.Customer;
import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@RestController
//@Controller
@RequestMapping("/customer")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String viewHomepage() {
        return "/HTML/First page";  // home page
    }

    @GetMapping("/login")
    public String login() {
        return "/HTML/login";  // home page
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/customer/signup") // Show customer signup form
    public String customerSignUp(Model model) {
        model.addAttribute("customer", new Customer());
        return "Customer/CustomerSignup"; // corrected file name
    }

    @GetMapping("/customer/login")
    public String customerLogin() {                 // Customer login
        return "Customer/Customerslogin";
    }

    @GetMapping("/restaurant-owners/login")
    public String restaurantLogin() {               // Restaurant login
        return "Restaurant/Restaurantlogin";
    }

    @GetMapping("/restaurant-owners/signup")
    public String restaurantSignUp(Model model) {    // Restaurant login
        model.addAttribute("restaurantOwner", new RestaurantOwner());
        return "Restaurant/RestaurantSignup";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {  // admin login
        return "Admin/AdminLogin";
    }
}

//@RestController
////@Controller
//@RequestMapping("/customer")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/home")
//    public String viewHomepage() {
//        return "/HTML/First page";  // home page
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "/HTML/login";  // home page
//    }
//
//
//    // add resturent login
//
//    @GetMapping("/restaurant-owners/login")
//    public String restaurantLogin() {               // Restaurant login
//        return "Restaurant/Restaurantlogin";
//    }
//
//    @GetMapping("/restaurant-owners/signup")
//    public String restaurantSignUp(Model model) {    // Restaurant login
//        model.addAttribute("restaurantOwner", new RestaurantOwner());
//        return "Restaurant/RestaurantSignup";
//    }
//
//    // add customer login
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        userService.registerUser(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//    @GetMapping("/customer/signup") // Show customer signup form
//    public String customerSignUp(Model model) {
//        model.addAttribute("customer", new Customer());
//        return "Customer/CustomerSinup"; // customer signup page
//    }
//
//    @GetMapping("/customer/login")
//    public String customerLogin() {                 // Customer login
//        return "Customer/Customerslogin";
//    }
//
////     add admin login
//
//    @GetMapping("/admin/login")
//    public String adminLogin() {  // admin login
//        return "Admin/AdminLogin";
//    }
//
//
//}
