package com.example.demo.services.impl;

import com.example.demo.dto.client.CreateClientDTO;
import com.example.demo.dto.client.GetAllClientsDTO;
import com.example.demo.dto.client.ReadClientDTO;
import com.example.demo.dto.client.UpdateClientDTO;
import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.services.ClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    @Transactional
    public CreateClientDTO create(CreateClientDTO createClientDTO) {
        Client client = new Client();
        client.setFirstName(createClientDTO.getFirstName());
        client.setLastName(createClientDTO.getLastName());
        client.setAge(createClientDTO.getAge());
        client.setLogin(createClientDTO.getLogin());
        client.setPassword(createClientDTO.getPassword());
        client.setCreditBalance(createClientDTO.getCreditBalance());
        Client savedClient = clientRepository.save(client);
        CreateClientDTO dto = new CreateClientDTO();
        dto.setId(savedClient.getId());
        dto.setFirstName(savedClient.getFirstName());
        dto.setLastName(savedClient.getLastName());
        dto.setAge(savedClient.getAge());
        dto.setLogin(savedClient.getLogin());
        dto.setPassword(savedClient.getPassword());
        dto.setCreditBalance(savedClient.getCreditBalance());
        return dto;
    }

    @Override
    public ReadClientDTO read(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        ReadClientDTO readClientDTO = new ReadClientDTO();
        readClientDTO.setId(client.getId());
        readClientDTO.setFirstName(client.getFirstName());
        readClientDTO.setLastName(client.getLastName());
        readClientDTO.setAge(client.getAge());
        readClientDTO.setLogin(client.getLogin());
        readClientDTO.setPassword(client.getPassword());
        readClientDTO.setCreditBalance(client.getCreditBalance());
        return readClientDTO;
    }

    @Override
    @Transactional
    public UpdateClientDTO update(UpdateClientDTO updateClientDTO, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setFirstName(updateClientDTO.getFirstName());
        client.setLastName(updateClientDTO.getLastName());
        client.setAge(updateClientDTO.getAge());
        client.setLogin(updateClientDTO.getLogin());
        client.setPassword(updateClientDTO.getPassword());
        client.setCreditBalance(updateClientDTO.getCreditBalance());
        Client savedClient = clientRepository.save(client);
        UpdateClientDTO dto = new UpdateClientDTO();
        dto.setId(savedClient.getId());
        dto.setFirstName(savedClient.getFirstName());
        dto.setLastName(savedClient.getLastName());
        dto.setAge(savedClient.getAge());
        dto.setLogin(savedClient.getLogin());
        dto.setPassword(savedClient.getPassword());
        dto.setCreditBalance(savedClient.getCreditBalance());
        return dto;
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<GetAllClientsDTO> getAll() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().map(client -> {
            GetAllClientsDTO getAllClientsDTO = new GetAllClientsDTO();
            getAllClientsDTO.setId(client.getId());
            getAllClientsDTO.setFirstName(client.getFirstName());
            getAllClientsDTO.setLastName(client.getLastName());
            getAllClientsDTO.setAge(client.getAge());
            getAllClientsDTO.setLogin(client.getLogin());
            getAllClientsDTO.setPassword(client.getPassword());
            getAllClientsDTO.setCreditBalance(client.getCreditBalance());
            return getAllClientsDTO;
        }).collect(Collectors.toList());
    }
}
