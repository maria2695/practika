package com.example.demo.controller;

import com.example.demo.dto.pizza.PizzaInfoDto;
import com.example.demo.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizzeria/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @PostMapping
    public PizzaInfoDto createPizza(@RequestBody PizzaInfoDto createPizzaDTO){
        return pizzaService.create(createPizzaDTO);
    }
    @GetMapping
    public PizzaInfoDto readPizza(@RequestParam Long id){
        return pizzaService.read(id);
    }
    @PutMapping
    public PizzaInfoDto updatePizza(@RequestBody PizzaInfoDto updatePizzaDTO, @RequestParam Long id){
        return pizzaService.update(updatePizzaDTO, id);
    }
    @DeleteMapping
    public void deletePizza(@RequestParam Long id){
        pizzaService.delete(id);
    }
    @GetMapping("/list")
    public List<PizzaInfoDto> pizzaList(){
        return pizzaService.getAll();
    }
}
