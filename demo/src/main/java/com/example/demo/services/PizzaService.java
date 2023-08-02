package com.example.demo.services;

import com.example.demo.dto.pizza.PizzaInfoDto;
import com.example.demo.entities.Pizza;

import java.util.List;

public interface PizzaService {
    PizzaInfoDto create(Pizza pizza, PizzaInfoDto pizzaInfoDto);
    PizzaInfoDto read(Long id);
    PizzaInfoDto update(PizzaInfoDto pizza, Long id);
    void delete(Long id);
    List<PizzaInfoDto> getAll();
}

