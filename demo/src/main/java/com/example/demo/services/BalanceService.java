package com.example.demo.services;

import com.example.demo.dto.balance.GetAllBalancesDTO;
import com.example.demo.entities.Balance;

import java.util.List;

public interface BalanceService {
    List<GetAllBalancesDTO> getAll();
}
