package com.example.demo.services.impl;

import com.example.demo.dto.pizza.PizzaInfoDto;
import com.example.demo.entities.Ingredient;
import com.example.demo.entities.Pizza;
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

    private Pizza maptoPizza(Pizza pizza, PizzaInfoDto pizzaInfoDto){
        pizza.setName(pizzaInfoDto.getName());
        Ingredient ingredient = new Ingredient();
        ingredient.setName(pizzaInfoDto.getName());
        return pizzaRepository.save(pizza);
    }

    private PizzaInfoDto mapToPizzaDto(Pizza pizza){
        PizzaInfoDto dto = new PizzaInfoDto();
        dto.setName(pizza.getName());
        dto.setIngredients(pizza.getIngredients());
        return dto;
    }


    @Override
    @Transactional
    public PizzaInfoDto create(Pizza pizza, PizzaInfoDto pizzaInfoDto) {
        Pizza savedPizza = maptoPizza(pizza, pizzaInfoDto);
        return mapToPizzaDto(savedPizza);
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
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        var updated = pizzaRepository.save(maptoPizza(pizza, updatePizzaDTO));
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

