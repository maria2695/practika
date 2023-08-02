package com.example.demo.services;

import com.example.demo.dto.client.ClientInfoDto;


import java.util.List;
public interface ClientService {
     ClientInfoDto create(ClientInfoDto createClientDTO);
     ClientInfoDto read(Long id);
     ClientInfoDto update(ClientInfoDto updateClientDTO, Long id);
     void delete(Long id);
     List<ClientInfoDto> getAll();
}
