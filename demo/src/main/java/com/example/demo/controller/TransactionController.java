package com.example.demo.controller;

import com.example.demo.entities.Transaction;
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
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }
    @GetMapping("/{id}")
    public Transaction readTransactions(@PathVariable Long id){
        return transactionService.read(id);
    }
    @GetMapping("/list")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAll();
    }

}
