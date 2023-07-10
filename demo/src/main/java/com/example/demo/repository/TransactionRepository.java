package com.example.demo.repository;

import com.example.demo.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Double calculateSumOfTransactionAmounts();

    Double calculateSumOfClientTransactionAmounts();
}
