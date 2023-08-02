package com.example.demo.services.impl;

import com.example.demo.dto.balance.BalanceInfoDto;
import com.example.demo.entities.Balance;
import com.example.demo.entities.Client;
import com.example.demo.repository.BalanceRepository;
import com.example.demo.repository.ClientRepository;
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
    private final ClientRepository clientRepository;

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

    @Override
    public void saveCurrentBalance(Long clientId, double balanceAmount, Date lastTransactionDate) {
        Balance balance = balanceRepository.findById(clientId).orElseThrow( () -> new RuntimeException("Not found"));
        if (balance != null) {
            balance.setBalanceAmount(balanceAmount);
            balance.setLastTransactionDate(lastTransactionDate);
        } else {
            balance = new Balance();
            balance.setBalanceAmount(balanceAmount);
            balance.setLastTransactionDate(lastTransactionDate);
            Client client = clientRepository.findById(clientId).orElseThrow(() -> new  RuntimeException("Client not found"));
            balance.setClientId(client);
        }
        balanceRepository.save(balance);
    }
}
