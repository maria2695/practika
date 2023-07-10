package com.example.demo.controller;

import com.example.demo.entities.Pizza;
import com.example.demo.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @PostMapping("/create")
    public Pizza createPizza(@RequestBody Pizza pizza){
        return pizzaService.create(pizza);
    }
    @GetMapping("/{id}")
    public Pizza readPizza(@PathVariable Long id){
        return pizzaService.read(id);
    }
    @PutMapping("/{id}")
    public Pizza updatePizza(@RequestBody Pizza pizza, @PathVariable Long id){
        return pizzaService.update(pizza, id);
    }
    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaService.delete(id);
    }
    @GetMapping("/list")
    public List<Pizza> pizzaList(){
        return pizzaService.getAll();
    }
}
