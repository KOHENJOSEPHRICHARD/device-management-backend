package com.phone.smart.Service;

import com.phone.smart.Model.User;
import com.phone.smart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Authenticate user by username and password
    public boolean authenticate(String username, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null) {
            // In a real application, you would hash the password and compare it with the stored hash
            if (user.getPassword().equals(password)) {
                return true;  // Authentication successful
            }
        }
        return false;  // Authentication failed
    }
}

