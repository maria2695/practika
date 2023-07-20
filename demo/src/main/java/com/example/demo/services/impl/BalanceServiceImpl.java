package com.example.demo.services.impl;

import com.example.demo.dto.balance.GetAllBalancesDTO;
import com.example.demo.entities.Balance;
import com.example.demo.repository.BalanceRepository;
import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    @Override
    public List<GetAllBalancesDTO> getAll() {
        List<Balance> balanceList = balanceRepository.findAll();
        return balanceList.stream().map(balance -> {
            GetAllBalancesDTO getAllBalancesDTO = new GetAllBalancesDTO();
            getAllBalancesDTO.setId(balance.getId());
            getAllBalancesDTO.setClientId(balance.getId());
            getAllBalancesDTO.setLastTransactionDate(balance.getLastTransactionDate());
            getAllBalancesDTO.setBalanceAmount(balance.getBalanceAmount());
            return getAllBalancesDTO;
        }).collect(Collectors.toList());
    }
    }
