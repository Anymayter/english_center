package com.toan.english_center.Controller;


import com.toan.english_center.Entity.Account;
import com.toan.english_center.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccount() {
        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public Optional<Account> getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        account.setaPwd(account.getaPwd()); // Ensure password is set correctly
        Account newAccount = accountService.createAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable String id, Account account) {
        Account updatedAccount = accountService.updateAccount(id, account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }
}
