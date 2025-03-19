package com.toan.english_center.Repository;


import com.toan.english_center.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    Optional<Account> findByaUid(String aUid);
    List<Account> findAll();
    Account save(Account account);
    void deleteById(String aId);
    Optional<Account> findById(String aId);


}
