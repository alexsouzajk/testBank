package com.jesus.alex.testBank.respository;

import com.jesus.alex.testBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
