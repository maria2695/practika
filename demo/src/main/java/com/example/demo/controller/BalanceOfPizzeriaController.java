package com.example.demo.controller;


import com.example.demo.entities.BalanceOfPizzeria;
import com.example.demo.services.BalanceOfPizzeriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/controller")
@RequiredArgsConstructor
public class BalanceOfPizzeriaController {
    private final BalanceOfPizzeriaService balanceOfPizzeriaService;

    @PostMapping("/create")
    public BalanceOfPizzeria createClient(@RequestBody BalanceOfPizzeria client) {
        return balanceOfPizzeriaService.create(client);
    }

    @GetMapping("/{id}")
    public BalanceOfPizzeria getByClientId(@PathVariable Long id) {
        return balanceOfPizzeriaService.getBalanceById(id);
    }

    @PutMapping("/{id}")
    public BalanceOfPizzeria updateClient(@PathVariable Long id, @RequestBody BalanceOfPizzeria client) {
        client.setId(id);
        return balanceOfPizzeriaService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        balanceOfPizzeriaService.delete(id);
    }

    @GetMapping
    public List<BalanceOfPizzeria> getAll() {
        return balanceOfPizzeriaService.getAll();
    }

}
