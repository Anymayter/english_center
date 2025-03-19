package com.toan.english_center.Service;

import com.toan.english_center.Entity.Account;
import com.toan.english_center.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Transactional
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Transactional
    public Optional<Account> getAccountById(String aId) {
        return accountRepository.findById(aId);
    }

    @Transactional
    public Account createAccount(Account account) {
        // Kiểm tra mật khẩu không được null hoặc rỗng
        if (account.getaPwd() == null || account.getaPwd().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        account.setCreatedDate(LocalDateTime.now());
        return accountRepository.save(account);
    }


    public Account updateAccount(String id, Account updatedAccount) {
        Optional<Account> existingAccountOpt = accountRepository.findById(id);
        if (existingAccountOpt.isPresent()) {
            Account existingAccount = existingAccountOpt.get();
            // Update fields
            existingAccount.setaUid(updatedAccount.getaUid());
            existingAccount.setaPwd(updatedAccount.getaPwd());
            existingAccount.setaType(updatedAccount.getaType());
            existingAccount.setaStatus(updatedAccount.getaStatus());
            existingAccount.setJsonData(updatedAccount.getJsonData());
            existingAccount.setUpdatedDate(updatedAccount.getUpdatedDate());
            return accountRepository.save(existingAccount);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
