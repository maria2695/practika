package com.example.demo.services;

import com.example.demo.dto.drink.CreateDrinkDTO;
import com.example.demo.dto.drink.GetAllDrinksDTO;
import com.example.demo.dto.drink.ReadDrinkDTO;
import com.example.demo.dto.drink.UpdateDrinkDTO;

import java.util.List;

public interface DrinkService {
     CreateDrinkDTO create(CreateDrinkDTO createDrinkDTO);
     ReadDrinkDTO read(Long id);
     UpdateDrinkDTO update(UpdateDrinkDTO updateDrinkDTO, Long id);
     void delete(Long id);
     List<GetAllDrinksDTO> getAll();
}
