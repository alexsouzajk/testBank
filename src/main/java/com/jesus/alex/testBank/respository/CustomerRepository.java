package com.jesus.alex.testBank.respository;

import com.jesus.alex.testBank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
