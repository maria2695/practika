package com.example.demo.services;

import com.example.demo.entities.BalanceOfPizzeria;

import java.util.List;

public interface BalanceOfPizzeriaService {
    BalanceOfPizzeria create (BalanceOfPizzeria balanceOfPizzeria);
    BalanceOfPizzeria getBalanceById (Long id);
    BalanceOfPizzeria update (BalanceOfPizzeria balanceOfPizzeria);
    void delete (Long id);
    List<BalanceOfPizzeria> getAll();
}
