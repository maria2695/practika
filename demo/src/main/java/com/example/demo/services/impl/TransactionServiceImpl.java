package com.example.demo.services.impl;

import com.example.demo.dto.transaction.TransactionInfoDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Transaction;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.services.TransactionService;
import jakarta.validation.constraints.Null;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private Transaction mapDtoToTransaction(TransactionInfoDto transactionInfoDto){
        var transaction = new Transaction();
        transaction.setTransactionDate(transactionInfoDto.getTransactionDate());
        transaction.setTransactionAmount(transactionInfoDto.getTransactionAmount());
        Client client = new Client();
        client.setId(transactionInfoDto.getClientId());
        return transactionRepository.save(transaction);
    }

    private TransactionInfoDto mapToTransactionDto(Transaction transaction){
        TransactionInfoDto dto = new TransactionInfoDto();
        dto.setTransactionDate(transaction.getTransactionDate());
        dto.setTransactionAmount(transaction.getTransactionAmount());
        dto.setClientId(transaction.getClient().getId());
        return dto;
    }

    @Override
    @Transactional
    public TransactionInfoDto create(TransactionInfoDto transactionInfoDto) {
        if(transactionInfoDto != null){
            var savedTransaction = transactionRepository.save(mapDtoToTransaction(transactionInfoDto));
            return mapToTransactionDto(savedTransaction);
        }
        throw new NullEntityReferenceException("Cannot be bull");
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionInfoDto read(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return mapToTransactionDto(transaction);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionInfoDto> getAll() {
        List<Transaction> transactionList= transactionRepository.findAll();
        return transactionList.stream()
                .map(this::mapToTransactionDto)
                .collect(Collectors.toList());
    }
}

