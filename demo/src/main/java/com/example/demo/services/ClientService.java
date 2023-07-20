package com.example.demo.services;

import com.example.demo.dto.client.CreateClientDTO;
import com.example.demo.dto.client.GetAllClientsDTO;
import com.example.demo.dto.client.ReadClientDTO;
import com.example.demo.dto.client.UpdateClientDTO;


import java.util.List;
public interface ClientService {
     CreateClientDTO create(CreateClientDTO createClientDTO);
     ReadClientDTO read(Long id);
     UpdateClientDTO update(UpdateClientDTO updateClientDTO, Long id);
     void delete(Long id);
     List<GetAllClientsDTO> getAll();
}
