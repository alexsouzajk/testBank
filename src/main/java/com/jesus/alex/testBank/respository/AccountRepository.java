package com.jesus.alex.testBank.respository;

import com.jesus.alex.testBank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT sum(balance) FROM account", nativeQuery = true)
    BigDecimal totalBalance();

}
