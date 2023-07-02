package com.example.demo.services.impl;

import com.example.demo.entities.Transaction;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
        if(transaction != null){
            return transactionRepository.save(transaction);
        }
        throw new NullEntityReferenceException("Cannot be null!");
    }

    @Override
    public Transaction getTransactionById (Long id) {
        return transactionRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Transaction with id"+ id + "not found")
        );
    }

    @Override
    public Transaction update(Transaction transaction) {
        if(transaction != null){
            getTransactionById (transaction.getId());
            transactionRepository.save(transaction);
        }
        throw new NullEntityReferenceException("Cannot be null!");
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = getTransactionById(id);
        transactionRepository.delete(transaction);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}
