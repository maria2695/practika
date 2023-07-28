package com.example.demo.controller;

import com.example.demo.dto.client.ClientInfoDto;
import com.example.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ClientInfoDto createClient(@RequestBody ClientInfoDto createClientDTO){
        return clientService.create(createClientDTO);
    }

    @GetMapping
    public ClientInfoDto readClient(@RequestParam Long id){
        return clientService.read(id);
    }

    @PutMapping
    public ClientInfoDto updateClient(@RequestBody ClientInfoDto client, @RequestParam Long id){
        return clientService.update(client, id);
    }
    @DeleteMapping
    public void deleteClient(@RequestParam Long id){
       clientService.delete(id);
    }
    @GetMapping("/list")
    public List<ClientInfoDto> getAllClients(){
        return clientService.getAll();
    }
}
