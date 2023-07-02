package com.example.demo.services;

import com.example.demo.entities.Client;

import java.util.List;

public interface ClientService {
    Client create (Client client);
    Client getClientById (Long id);
    Client update (Client client);
    void delete (Long id);
    List<Client> getAll();
}
