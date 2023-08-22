package com.example.demo.services;

import com.example.demo.dto.transaction.TransactionInfoDto;
import com.example.demo.entities.Transaction;

import java.util.List;

public interface TransactionService {
   TransactionInfoDto create(TransactionInfoDto transactionInfoDto);
   TransactionInfoDto read(Long id);
   List<TransactionInfoDto> getAll();
}

