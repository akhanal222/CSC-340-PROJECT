package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {

        if (customerRepository.findByUsername(customer.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        customer.setPassword(/*passwordEncoder.encode*/(customer.getPassword()));
        customer.setRole("CUSTOMER"); // Set a role to the customer
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setFirstName(customerDetails.getFirstName());
            existingCustomer.setLastName(customerDetails.getLastName());
            existingCustomer.setEmail(customerDetails.getEmail());
            existingCustomer.setUsername(customerDetails.getUsername());
            if (!existingCustomer.getPassword().equals(customerDetails.getPassword())) {
                existingCustomer.setPassword(customerDetails.getPassword());
            }
            existingCustomer.setAddress(customerDetails.getAddress());
            existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        }
        throw new IllegalArgumentException("Customer not found");
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
