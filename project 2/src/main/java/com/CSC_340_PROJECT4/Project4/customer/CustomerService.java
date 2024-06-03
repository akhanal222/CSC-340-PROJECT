package com.CSC_340_PROJECT4.Project4.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(id);

        // if exist update info can be updated
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            existingCustomer.setFirstName(customerDetails.getFirstName());
            existingCustomer.setLastName(customerDetails.getLastName());
            existingCustomer.setEmail(customerDetails.getEmail());
            existingCustomer.setUsername(customerDetails.getUsername());
            existingCustomer.setPassword(customerDetails.getPassword());
            existingCustomer.setAddress(customerDetails.getAddress());
            existingCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
