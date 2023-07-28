package com.example.demo.controller;

import com.example.demo.dto.transaction.TransactionInfoDto;
import com.example.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping
    public TransactionInfoDto createTransaction(@RequestBody TransactionInfoDto createTransactionDTO){
        return transactionService.create(createTransactionDTO);
    }
    @GetMapping
    public TransactionInfoDto readTransactions(@RequestParam Long id){
        return transactionService.read(id);
    }
    @GetMapping("/list")
    public List<TransactionInfoDto> getAllTransactions(){
        return transactionService.getAll();
    }
}
