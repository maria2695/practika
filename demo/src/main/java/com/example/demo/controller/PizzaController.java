package com.example.demo.controller;



import com.example.demo.entities.Pizza;
import com.example.demo.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza/pizzas")
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;

    @PostMapping("/create")
    public Pizza create(@RequestBody Pizza drink){
        return pizzaService.create(drink);
    }

    @GetMapping("/{id}")
    public Pizza getByDrinkId(@PathVariable Long id){
        return pizzaService.getPizzaById(id);
    }
    @PutMapping("/{id}")
    public Pizza update(@PathVariable Long id, @RequestBody Pizza drink) {
        drink.setId(id);
        return pizzaService.update(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        pizzaService.delete(id);
    }

    @GetMapping
    public List<Pizza> pizzaList(){
        return pizzaService.getAll();
    }

}
