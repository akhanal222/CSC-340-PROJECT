package com.CSC_340_PROJECT4.Project4.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        // Check if the user is null
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        // Check if the role is valid
        if (user.getRole() == null || user.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
