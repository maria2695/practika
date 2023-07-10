package com.example.demo.services.impl;

import com.example.demo.entities.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    @Override
    public Transaction read(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}
