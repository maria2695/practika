package com.example.demo.services;

import com.example.demo.dto.transaction.CreateTransactionDTO;
import com.example.demo.dto.transaction.GetAllTransactionsDTO;
import com.example.demo.dto.transaction.ReadTransactionDTO;
import java.util.List;

public interface TransactionService {
   CreateTransactionDTO create(CreateTransactionDTO transaction);
   ReadTransactionDTO read(Long id);
   List<GetAllTransactionsDTO> getAll();
}
