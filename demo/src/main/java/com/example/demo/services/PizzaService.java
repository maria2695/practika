package com.example.demo.services;



import com.example.demo.entities.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza create(Pizza pizza);
    Pizza read(Long id);
    Pizza update(Pizza pizza, Long id);
    void delete(Long id);
    List<Pizza> getAll();
}
