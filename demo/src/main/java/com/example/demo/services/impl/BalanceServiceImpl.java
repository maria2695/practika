package com.example.demo.services.impl;

import com.example.demo.dto.balance.BalanceInfoDto;
import com.example.demo.entities.Balance;
import com.example.demo.repository.BalanceRepository;
import com.example.demo.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    private BalanceInfoDto mapToBalanceDto(Balance balance){
        BalanceInfoDto dto = new BalanceInfoDto();
        dto.setClientId(balance.getId());
        dto.setLastTransactionDate(balance.getLastTransactionDate());
        dto.setBalanceAmount(balance.getBalanceAmount());
        return dto;
    }

    @Override
    public List<BalanceInfoDto> getAll() {
        List<Balance> balanceList = balanceRepository.findAll();
        return balanceList.stream()
                .map(this::mapToBalanceDto)
                .collect(Collectors.toList());
    }
    }
