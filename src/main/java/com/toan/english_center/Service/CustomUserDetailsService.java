package com.toan.english_center.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For simplicity, using a hardcoded user. In a real application, you would fetch user details from a database.
        if ("user".equals(username)) {
            return new org.springframework.security.core.userdetails.User(
                    "user",
                    passwordEncoder.encode("password"),
                    Collections.emptyList()
            );
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
