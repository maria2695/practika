package com.example.demo.repository;

import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(t.transactionAmount) FROM Transaction t WHERE t.client.id = :clientId")
    Double calculateSumOfClientTransactionAmounts(@Param("clientId") Long clientId);

}
