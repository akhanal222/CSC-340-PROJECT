/*
package com.CSC_340_PROJECT4.Project4.customer;

import com.CSC_340_PROJECT4.Project4.restaurant.RestaurantOwner;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/home")
    public String viewHomepage() {
        return "/HTML/First page";  // home page
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
*/

package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.stereotype.Controller;

@Controller
public class AppController {

    /*@Autowired
    private CustomerRepository customerRepository;*/

   /* @GetMapping("/home")
    public String viewHomepage() {
        return "/HTML/First page";  // home page
    }*/

   /* @GetMapping("/customer/signup")
    public String customerSignUp(Model model) {
        model.addAttribute("customer", new Customer());
        return "Customer/CustomerSignup";            // customer Signup
    }
*/
    /*@PostMapping("/customer/create")
    public String createCustomer(@ModelAttribute Customer customer) {
        customer.setRole("CUSTOMER"); // Set the role to CUSTOMER
        customerRepository.save(customer);
        return "redirect:/customer/login";
    }*/

    /*@GetMapping("/login")
    public String customerLogin() {                 // Customer login
        return "Customer/Customerslogin";
    }*/

    /*@GetMapping("/restaurant/login")
    public String restaurantLogin() {               // Restaurant login
        return "Restaurant/Restaurantlogin";
    }*/

   /* @GetMapping("/restaurant/signup")
    public String restaurantSignUp(Model model) {    // Restaurant login
        model.addAttribute("restaurantOwner", new RestaurantOwner());
        return "Restaurant/RestaurantSignup";
    }*/

   /* @GetMapping("/admin/login")
    public String adminLogin() {  // admin login
        return "Admin/AdminLogin";
    }*/
}
