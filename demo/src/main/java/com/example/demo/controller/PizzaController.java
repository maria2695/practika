package com.example.demo.controller;

import com.example.demo.dto.pizza.CreatePizzaDTO;
import com.example.demo.dto.pizza.GetAllPizzaDTO;
import com.example.demo.dto.pizza.ReadPizzaDTO;
import com.example.demo.dto.pizza.UpdatePizzaDTO;
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
    public CreatePizzaDTO createPizza(@RequestBody CreatePizzaDTO createPizzaDTO){
        return pizzaService.create(createPizzaDTO);
    }
    @GetMapping("/{id}")
    public ReadPizzaDTO readPizza(@RequestParam Long id){
        return pizzaService.read(id);
    }
    @PutMapping("/{id}")
    public UpdatePizzaDTO updatePizza(@RequestBody UpdatePizzaDTO updatePizzaDTO, @RequestParam Long id){
        return pizzaService.update(updatePizzaDTO, id);
    }
    @DeleteMapping("/{id}")
    public void deletePizza(@RequestParam Long id){
        pizzaService.delete(id);
    }
    @GetMapping("/list")
    public List<GetAllPizzaDTO> pizzaList(){
        return pizzaService.getAll();
    }
}
