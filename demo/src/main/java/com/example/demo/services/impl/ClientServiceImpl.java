package com.example.demo.services.impl;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.dto.client.CreateClientDto;
import com.example.demo.entities.Client;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.ClientRepository;
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
    private Client mapToClient(Client client, CreateClientDto createClientDto) {
        client.setFirstName(createClientDto.getFirstName());
        client.setLastName(createClientDto.getLastName());
        client.setAge(createClientDto.getAge());
        client.setLogin(createClientDto.getLogin());
        client.setPassword(createClientDto.getPassword());
        client.setCreditBalance(createClientDto.getCreditBalance());
        return clientRepository.save(client);

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
    public CreateClientDto create(Client client, CreateClientDto createClient) {
        if(createClient != null){
            Client savedClient = mapToClient(client,createClient);
            return mapToClientDto(savedClient);
        }
        throw new NullEntityReferenceException("Cannot be null");
    }

    @Override
    @Transactional(readOnly = true)
    public CreateClientDto read(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return mapToClientDto(client);
    }

    @Override
    @Transactional
    public CreateClientDto update(CreateClientDto updateClientDto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        var updated = clientRepository.save(mapToClient(client, updateClientDto));
        return mapToClientDto(updated);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreateClientDto> getAll() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}
