/*
package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all") // Return all the user
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}") // get costumer by id
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
*/
/*
    @PostMapping("/create") // create new customer
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }*//*


    @PostMapping("/create")
    public String createCustomer(Customer customer, Model model) {
        Customer createdCustomer = customerService.createCustomer(customer);
        model.addAttribute("customer", createdCustomer);
        return "redirect:/customer/login"; // Redirect to login page after successful signup
    }


    @PutMapping("/update/{id}") // update previous
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
*/


package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")  // Get all the user
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}") // get customer by their id
    @ResponseBody
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/create")  // Make a new Customer
    public String createCustomer(Customer customer, Model model) {
        Customer createdCustomer = customerService.createCustomer(customer);
        model.addAttribute("customer", createdCustomer);
        return "redirect:/customer/login"; // Redirect to login page after successful signup
    }


    @PutMapping("/update/{id}")  //update Customer by ID
    @ResponseBody
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(id, customerDetails);
    }

    @DeleteMapping("/delete/{id}")    // delete Customer by ID
    @ResponseBody
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
