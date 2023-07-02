package com.example.demo.services;

import com.example.demo.entities.Client;
import com.example.demo.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction create (Transaction transaction);
    Transaction getTransactionById(Long id);
    Transaction update (Transaction transaction);
    void delete (Long id);
    List<Transaction> getAll();
}
