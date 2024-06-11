package com.CSC_340_PROJECT4.Project4.customer;

import com.CSC_340_PROJECT4.Project4.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "customer")
public class Customer extends User {

    @NonNull
    private String firstName; // First name of the customer.

    @NonNull
    private String lastName; // Last name of the customer.

    @NonNull
    private String address; // Address of the customer.

    @NonNull
    private String phoneNumber; // Phone number of customer.

    public Customer() {
        super();
    }

    public Customer(@NonNull String username, @NonNull String firstName, @NonNull String lastName, @NonNull String address, @NonNull String phoneNumber, @NonNull String password, @NonNull String email, @NonNull String role) {
        super.setUsername(username);
        super.setPassword(password);
        super.setEmail(email);
        super.setRole(role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
