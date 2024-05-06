package com.jesus.alex.testBank.respository;

import com.jesus.alex.testBank.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}
