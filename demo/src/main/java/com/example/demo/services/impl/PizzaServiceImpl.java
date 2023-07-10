package com.example.demo.services.impl;

import com.example.demo.entities.Pizza;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza read(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    @Override
    public Pizza update(Pizza pizza, Long id) {
        Pizza exitedPizza = pizzaRepository.findById(id).orElse(null);
        if(exitedPizza != null){
            exitedPizza.setName(pizza.getName());
            exitedPizza.setIngredients((pizza.getIngredients()));
        }
        return pizzaRepository.save(pizza);
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }
    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }
}
