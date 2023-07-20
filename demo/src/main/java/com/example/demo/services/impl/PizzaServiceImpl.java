package com.example.demo.services.impl;

import com.example.demo.dto.pizza.CreatePizzaDTO;
import com.example.demo.dto.pizza.GetAllPizzaDTO;
import com.example.demo.dto.pizza.ReadPizzaDTO;
import com.example.demo.dto.pizza.UpdatePizzaDTO;
import com.example.demo.dto.staff.GetAllStaffDTO;
import com.example.demo.dto.transaction.CreateTransactionDTO;
import com.example.demo.dto.transaction.ReadTransactionDTO;
import com.example.demo.entities.Ingredient;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.Staff;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.PizzaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    @Override
    @Transactional
    public CreatePizzaDTO create(CreatePizzaDTO createPizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setName(createPizzaDTO.getName());
        Ingredient ingredient = new Ingredient();
        ingredient.setName(createPizzaDTO.getName());
        Pizza savedPizza = pizzaRepository.save(pizza);
        CreatePizzaDTO dto = new CreatePizzaDTO();
        dto.setId(savedPizza.getId());
        dto.setName(savedPizza.getName());
        dto.setIngredients(savedPizza.getIngredients());
        return dto;
    }

    @Override
    public ReadPizzaDTO read(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        ReadPizzaDTO readPizzaDTO = new ReadPizzaDTO();
        readPizzaDTO.setId(pizza.getId());
        readPizzaDTO.setName(pizza.getName());
        readPizzaDTO.setIngredients(pizza.getIngredients());
        return readPizzaDTO;
    }

    @Override
    @Transactional
    public UpdatePizzaDTO update(UpdatePizzaDTO updatePizzaDTO, Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        pizza.setName(updatePizzaDTO.getName());
        Ingredient ingredient = new Ingredient();
        ingredient.setName(updatePizzaDTO.getName());
        Pizza savedPizza = pizzaRepository.save(pizza);
        UpdatePizzaDTO dto = new UpdatePizzaDTO();
        dto.setId(savedPizza.getId());
        dto.setName(savedPizza.getName());
        dto.setIngredients(savedPizza.getIngredients());
        return dto;
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    public List<GetAllPizzaDTO> getAll() {
        List<Pizza> pizza1 = pizzaRepository.findAll();
        return pizza1.stream().map(pizza -> {
            GetAllPizzaDTO dto = new GetAllPizzaDTO();
            dto.setId(pizza.getId());
            dto.setName(pizza.getName());
            dto.setIngredients(pizza.getIngredients());
            return dto;
        }).collect(Collectors.toList());
    }
    }
