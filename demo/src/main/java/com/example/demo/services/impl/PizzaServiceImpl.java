package com.example.demo.services.impl;

import com.example.demo.dto.pizza.PizzaInfoDto;
import com.example.demo.entities.Ingredient;
import com.example.demo.entities.Pizza;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.PizzaService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    private Pizza mapDtotoPizza(PizzaInfoDto pizzaInfoDto){
        var pizza = new Pizza();
        pizza.setName(pizzaInfoDto.getName());
        Ingredient ingredient = new Ingredient();
        ingredient.setName(pizzaInfoDto.getName());
        return pizza;
    }

    private PizzaInfoDto mapToPizzaDto(Pizza pizza){
        PizzaInfoDto dto = new PizzaInfoDto();
        dto.setName(pizza.getName());
        dto.setIngredients(pizza.getIngredients());
        return dto;
    }


    @Override
    @Transactional
    public PizzaInfoDto create(PizzaInfoDto pizzaInfoDto) {
        if(pizzaInfoDto != null){
           var savedPizza = pizzaRepository.save(mapDtotoPizza(pizzaInfoDto));
            return mapToPizzaDto(savedPizza);
        }
        throw new NullEntityReferenceException("Cannot be null");
    }

    @Override
    @Transactional(readOnly = true)
    public PizzaInfoDto read(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        return mapToPizzaDto(pizza);
    }

    @Override
    @Transactional
    public PizzaInfoDto update(PizzaInfoDto updatePizzaDTO, Long id) {
       var pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        var updated = pizzaRepository.save(mapDtotoPizza(updatePizzaDTO));
        return mapToPizzaDto(updated);
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PizzaInfoDto> getAll() {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        return pizzaList.stream()
                .map(this::mapToPizzaDto)
                .collect(Collectors.toList());
    }
}

