package com.example.demo.controller;

import com.example.demo.dto.client.CreateClientDTO;
import com.example.demo.dto.client.GetAllClientsDTO;
import com.example.demo.dto.client.ReadClientDTO;
import com.example.demo.dto.client.UpdateClientDTO;
import com.example.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public CreateClientDTO createClient(@RequestBody CreateClientDTO createClientDTO){
        return clientService.create(createClientDTO);
    }

    @GetMapping("/{id}")
    public ReadClientDTO readClient(@RequestParam Long id){
        return clientService.read(id);
    }

    @PutMapping("/{id}")
    public UpdateClientDTO updateClient(@RequestBody UpdateClientDTO client, @RequestParam Long id){
        return clientService.update(client, id);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@RequestParam Long id){
       clientService.delete(id);
    }
    @GetMapping("/list")
    public List<GetAllClientsDTO> getAllClients(){
        return clientService.getAll();
    }
}
