package com.example.demo.services;

import com.example.demo.entities.Transaction;

import java.util.List;

public interface TransactionService {
   Transaction create(Transaction transaction);
   Transaction read(Long id);
   List<Transaction> getAll();
}
