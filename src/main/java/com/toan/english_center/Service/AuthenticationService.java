package com.toan.english_center.Service;


import com.toan.english_center.DTO.AuthenticationResponse;
import com.toan.english_center.Entity.Account;
import com.toan.english_center.Repository.AccountRepository;
import com.toan.english_center.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtUtil jwtUtil;

//    public String authenticate(String username, String password) {
//        Optional<Account> accountOpt = accountRepository.findByUsername(username);
//        if (accountOpt.isEmpty()) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        Account account = accountOpt.get();
//        if (account.getStatus() != 1) {
//            throw new BadCredentialsException("Account is inactive");
//        }
//        if (!account.getPassword().equals(password)) {
//            throw new BadCredentialsException("Invalid password");
//        }
//        String role = getRoleFromType(account.getType());
//        return jwtUtil.generateToken(account.getId(), role);
//    }

    public AuthenticationResponse authenticate(String username, String password) {
        Optional<Account> accountOpt = accountRepository.findByUsername(username);
        if (accountOpt.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        Account account = accountOpt.get();
        if (account.getStatus() != 1) {
            throw new BadCredentialsException("Account is inactive");
        }
        if (!account.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid password");
        }
        String role = getRoleFromType(account.getType());
        String token = jwtUtil.generateToken(account.getId(), role);
        return new AuthenticationResponse(token, role);
    }

    private String getRoleFromType(int type) {
        switch (type) {
            case 0: return "ADMIN";
            case 1: return "TEACHER";
            case 2: return "STUDENT";
            case 3: return "STAFF";
            default: throw new IllegalArgumentException("Invalid account type");
        }
    }
}
