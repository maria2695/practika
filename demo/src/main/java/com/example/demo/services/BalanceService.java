package com.example.demo.services;

import com.example.demo.dto.balance.BalanceInfoDto;

import java.util.List;

public interface BalanceService {
    List<BalanceInfoDto> getAll();
}
