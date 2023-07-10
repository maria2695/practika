package com.example.demo.services.impl;

import com.example.demo.controller.BalanceController;
import com.example.demo.entities.Balance;
import com.example.demo.repository.BalanceRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository, TransactionRepository transactionRepository) {
        this.balanceRepository = balanceRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void saveCurrentBalance(Balance balance) {


        Double sumOfClientTransactionAmounts = transactionRepository.calculateSumOfClientTransactionAmounts(balance.getClient().getId());


        Balance newBalance = new Balance();
        newBalance.setLastTransactionDate(new Date());
        balanceRepository.save(newBalance);
    }
}
