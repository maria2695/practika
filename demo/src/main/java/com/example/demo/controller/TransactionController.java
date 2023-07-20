package com.example.demo.controller;

import com.example.demo.dto.transaction.CreateTransactionDTO;
import com.example.demo.dto.transaction.GetAllTransactionsDTO;
import com.example.demo.dto.transaction.ReadTransactionDTO;
import com.example.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/create")
    public CreateTransactionDTO createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO){
        return transactionService.create(createTransactionDTO);
    }
    @GetMapping("/{id}")
    public ReadTransactionDTO readTransactions(@RequestParam Long id){
        return transactionService.read(id);
    }
    @GetMapping("/list")
    public List<GetAllTransactionsDTO> getAllTransactions(){
        return transactionService.getAll();
    }
}
