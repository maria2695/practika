package com.example.demo.services.impl;

import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create( Client client) {
        return clientRepository.save(client);

    }
    @Override
    public Client read( Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client, Long id) {
        Client excitedClient = clientRepository.findById(id).orElse(null);
        if(excitedClient != null){
            excitedClient.setFirstName(client.getFirstName());
            excitedClient.setLastName(client.getLastName());
            excitedClient.setAge(client.getAge());
            excitedClient.setLogin(client.getLogin());
            excitedClient.setPassword(client.getPassword());
            excitedClient.setCreditBalance(client.getCreditBalance());
        }
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

}
