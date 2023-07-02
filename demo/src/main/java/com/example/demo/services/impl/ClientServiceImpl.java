package com.example.demo.services.impl;

import com.example.demo.entities.Client;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override

    public Client create(Client client) {
        if (client != null) {
            return clientRepository.save(client);
        }
        throw new NullEntityReferenceException("Client cannot be 'null'");
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Client with id " + id + " not found"));
    }

    @Override
    public Client update(Client client) {
        if(client != null){
            getClientById(client.getId());
            return clientRepository.save(client);
        }
        throw new NullEntityReferenceException("Client cannot be 'null'");
    }

    @Override
    public void delete(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);

    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

}
