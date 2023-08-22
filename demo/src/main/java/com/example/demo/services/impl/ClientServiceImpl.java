package com.example.demo.services.impl;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.dto.client.CreateClientDto;
import com.example.demo.entities.Client;
import com.example.demo.entities.Drink;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.Transaction;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.ClientService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final PizzaRepository pizzaRepository;
    private final DrinkRepository drinkRepository;
    private Client maptoDtoClient(CreateClientDto createClientDto) {
        var client = new Client();
        client.setFirstName(createClientDto.getFirstName());
        client.setLastName(createClientDto.getLastName());
        client.setAge(createClientDto.getAge());
        client.setLogin(createClientDto.getLogin());
        client.setPassword(createClientDto.getPassword());
        client.setCreditBalance(createClientDto.getCreditBalance());
        return client;
    }

    private CreateClientDto mapToClientDto(Client client) {
        CreateClientDto dto = new CreateClientDto();
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setAge(client.getAge());
        dto.setLogin(client.getLogin());
        dto.setPassword(client.getPassword());
        dto.setCreditBalance(client.getCreditBalance());
        return dto;
    }
    @Override
    @Transactional
    public ClientInfoDto create(CreateClientDto createClient) {
        if(createClient != null) {
            var savedClient = clientRepository.save(maptoDtoClient(createClient));
            return mapToClientDto(savedClient);
        }
        throw new NullEntityReferenceException("Cannot be null");
    }

    @Override
    @Transactional(readOnly = true)
    public CreateClientDto read(Long id) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return mapToClientDto(client);
    }

    @Override
    @Transactional
    public CreateClientDto update(CreateClientDto updateClientDto, Long id) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        var updated = clientRepository.save(maptoDtoClient(updateClientDto));
        return mapToClientDto(updated);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientInfoDto> getAll() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean authentication(String login, String password) {
        var client = clientRepository.findByLogin(login);
        if(client != null && client.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Pizza> getPizzasList() {
        return pizzaRepository.findAll();
    }

    @Override
    public List<Drink> getDrinksList() {
        return drinkRepository.findAll();
    }

    @Override
    public void deactivateAccount(Client client) {
        if(!client.isActive()){
            System.out.println("Account is already deactivated");
            return;
        }
        client.setActive(false);
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void makeOrder(Long clientId, Long pizzaId, Long drinkId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        var pizza = pizzaRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        var drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new RuntimeException("Drink not found"));
        double totalCost = pizza.getPrice() + drink.getPrice();

        if(client.getCreditBalance()< totalCost){
            throw new NullEntityReferenceException("Insufficient balance to place the order");
        }

        double newBalance = client.getCreditBalance() - totalCost;
        client.setCreditBalance(newBalance);

        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void addMoney(Long clientId, double amount) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        double newBalance = client.getCreditBalance() + amount;
        client.setCreditBalance(newBalance);
        clientRepository.save(client);
    }

    @Override
    public List<Transaction> getTransactionsHistory(Long clientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getTransactionHistory();
    }

    @Override
    @Transactional(readOnly = true)
    public double getCurrentBalance(Long clientId) {
        var client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getCreditBalance();
    }
}

