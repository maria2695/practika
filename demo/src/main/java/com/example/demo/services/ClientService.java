package com.example.demo.services;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.dto.client.CreateClientDto;
import com.example.demo.entities.Client;


import java.util.List;
public interface ClientService {
     CreateClientDto create(Client client, CreateClientDto createClientDto);
     CreateClientDto read(Long id);
     CreateClientDto update(CreateClientDto updateClientDTO, Long id);
     void delete(Long id);
     List<CreateClientDto> getAll();
}

