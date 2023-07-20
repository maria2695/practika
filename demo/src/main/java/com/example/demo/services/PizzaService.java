package com.example.demo.services;

import com.example.demo.dto.pizza.CreatePizzaDTO;
import com.example.demo.dto.pizza.GetAllPizzaDTO;
import com.example.demo.dto.pizza.ReadPizzaDTO;
import com.example.demo.dto.pizza.UpdatePizzaDTO;
import java.util.List;

public interface PizzaService {
    CreatePizzaDTO create(CreatePizzaDTO pizza);
    ReadPizzaDTO read(Long id);
    UpdatePizzaDTO update(UpdatePizzaDTO pizza, Long id);
    void delete(Long id);
    List<GetAllPizzaDTO> getAll();
}
