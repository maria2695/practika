package com.example.demo.services.impl;

import com.example.demo.entities.Pizza;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.PizzaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }


    @Override
    public Pizza create(Pizza pizza) {
        pizza.setNameOfPizza(pizza.getNameOfPizza());
        pizza.setListOfIngredients(pizza.getListOfIngredients());
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Pizza with id " + id + " not found"));
    }

    @Override
    public Pizza update(Pizza pizza) {
        if(pizza != null){
            getPizzaById(pizza.getId());
            pizza.setNameOfPizza(pizza.getNameOfPizza());
            pizza.setListOfIngredients(pizza.getListOfIngredients());
            return pizzaRepository.save(pizza);
        }
        throw new NullEntityReferenceException("Cannot be 'null'");
    }

    @Override
    public void delete(Long id) {
        Pizza pizza = getPizzaById(id);
        pizzaRepository.delete(pizza);

    }

    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }
}
