package com.example.demo.services.impl;

import com.example.demo.dto.transaction.CreateTransactionDTO;
import com.example.demo.dto.transaction.GetAllTransactionsDTO;
import com.example.demo.dto.transaction.ReadTransactionDTO;
import com.example.demo.entities.Client;
import com.example.demo.entities.Transaction;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.services.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public CreateTransactionDTO create(CreateTransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setTransactionAmount(transactionDTO.getTransactionAmount());
        Client client = new Client();
        client.setId(transactionDTO.getClientId());
        Transaction savedTransaction = transactionRepository.save(transaction);
        CreateTransactionDTO createdTransactionDTO = new CreateTransactionDTO();
        createdTransactionDTO.setId(savedTransaction.getId());
        createdTransactionDTO.setTransactionDate(savedTransaction.getTransactionDate());
        createdTransactionDTO.setTransactionAmount(savedTransaction.getTransactionAmount());
        createdTransactionDTO.setClientId(savedTransaction.getClient().getId());
        return createdTransactionDTO;
    }

    @Override
    public ReadTransactionDTO read(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        ReadTransactionDTO readTransactionDTO = new ReadTransactionDTO();
        readTransactionDTO.setId(transaction.getId());
        readTransactionDTO.setTransactionDate(transaction.getTransactionDate());
        readTransactionDTO.setTransactionAmount(transaction.getTransactionAmount());
        return readTransactionDTO;
    }

    @Override
    public List<GetAllTransactionsDTO> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> {
            GetAllTransactionsDTO getAllTransactionsDTO = new GetAllTransactionsDTO();
            getAllTransactionsDTO.setId(transaction.getId());
            getAllTransactionsDTO.setTransactionDate(transaction.getTransactionDate());
            getAllTransactionsDTO.setTransactionAmount(transaction.getTransactionAmount());
            getAllTransactionsDTO.setClientId(transaction.getClient().getId());
            return getAllTransactionsDTO;
        }).collect(Collectors.toList());
    }
}
