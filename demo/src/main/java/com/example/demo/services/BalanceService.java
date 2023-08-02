package com.example.demo.services;

import com.example.demo.dto.balance.BalanceInfoDto;

import java.util.Date;
import java.util.List;

public interface BalanceService {
    List<BalanceInfoDto> getAll();
    void saveCurrentBalance(Long clientId, double balanceAmount, Date lastTransactionDate);
}
