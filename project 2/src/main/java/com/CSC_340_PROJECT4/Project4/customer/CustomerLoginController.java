package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerLoginController {

    @GetMapping("/customer/login")
    public String customerLogin() {
        return "Customer/Customerslogin";
    }
}

// This is not used it is for front login page only