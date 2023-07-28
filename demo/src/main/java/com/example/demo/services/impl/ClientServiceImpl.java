package com.example.demo.services.impl;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private Client mapToClient(ClientInfoDto clientInfoDTO) {
        Client client = new Client();
        client.setFirstName(clientInfoDTO.getFirstName());
        client.setLastName(clientInfoDTO.getLastName());
        client.setAge(clientInfoDTO.getAge());
        client.setLogin(clientInfoDTO.getLogin());
        client.setPassword(clientInfoDTO.getPassword());
        client.setCreditBalance(clientInfoDTO.getCreditBalance());
        return clientRepository.save(client);

    }

    private ClientInfoDto mapToClientDto(Client client) {
        ClientInfoDto dto = new ClientInfoDto();
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
    public ClientInfoDto create(ClientInfoDto createClient) {
        if(createClient != null){
            Client savedClient = mapToClient(createClient);
            return mapToClientDto(savedClient);
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public ClientInfoDto read(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return mapToClientDto(client);
    }

    @Override
    @Transactional
    public ClientInfoDto update(ClientInfoDto updateClientDto, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        mapToClient(updateClientDto);
        return mapToClientDto(client);
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
}
