package com.jesus.alex.testBank.respository;

import com.jesus.alex.testBank.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    @Query(value = "SELECT t from Transactions t " +
            " JOIN Account ac " +
            " ON t.originAccount.id = ac.id OR t.destinationAccount.id = ac.id " +
            " JOIN Customer c " +
            " ON c.account.id = ac.id " +
            " WHERE c.id = :id ", nativeQuery = false)
    Optional<List<Transactions>> findByCustomerId(@Param("id") Long id);

    @Query(value = "select t FROM Transactions t WHERE t.date BETWEEN :startDate AND :finalDate")
    List<Transactions> findByDate(@Param("startDate") Date startDate, @Param("finalDate") Date finalDate);

}
