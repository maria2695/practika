package com.example.demo.services;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.dto.client.CreateClientDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Drink;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.Transaction;


import java.util.List;
public interface ClientService {
     ClientInfoDto create(CreateClientDto createClientDto);
     ClientInfoDto read(Long id);
     ClientInfoDto update(CreateClientDto updateClientDTO, Long id);
     void delete(Long id);
     List<ClientInfoDto> getAll();
     boolean authentication(String login, String password);
     List<Pizza> getPizzasList();
     List<Drink> getDrinksList();
     void deactivateAccount(Client client);
     void makeOrder(Long clientId, Long pizzaId, Long drinkId);
     void addMoney(Long clientId, double amount);
     List<Transaction> getTransactionsHistory(Long clientId);
     double getCurrentBalance(Long clientId);
}

