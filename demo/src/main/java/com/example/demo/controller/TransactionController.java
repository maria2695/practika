package com.example.demo.controller;

import com.example.demo.entities.Transaction;
import com.example.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }
    public Transaction readTransactions(@PathVariable Long id){
        return transactionService.read(id);
    }
    public List<Transaction> getAllTransactions(){
        return transactionService.getAll();
    }

}
