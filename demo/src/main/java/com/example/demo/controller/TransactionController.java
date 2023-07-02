package com.example.demo.controller;

import com.example.demo.entities.Transaction;
import com.example.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/create")
    public Transaction create(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    public Transaction getByTransactionId(@PathVariable Long id){
        return transactionService.getTransactionById (id);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction){
        transaction.setId(id);
        return transactionService.update(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        transactionService.delete(id);
    }

    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }




}
