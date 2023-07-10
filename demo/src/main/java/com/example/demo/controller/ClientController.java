package com.example.demo.controller;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public Client createClient(@RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping("/{id}")
    public Client readClient(@PathVariable Long id){
        return clientService.read(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable Long id){
        return clientService.update(client, id);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
       clientService.delete(id);
    }
    @GetMapping("/list")
    public List<Client> getAllClients(){
        return clientService.getAll();
    }







}
