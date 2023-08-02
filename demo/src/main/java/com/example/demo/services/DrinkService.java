package com.example.demo.services;

import com.example.demo.dto.drink.DrinkInfoDto;
import com.example.demo.entities.Drink;

import java.util.List;

public interface DrinkService {
     DrinkInfoDto create(Drink drink, DrinkInfoDto createDrinkDTO);
     DrinkInfoDto read(Long id);
     DrinkInfoDto update(DrinkInfoDto updateDrinkDTO, Long id);
     void delete(Long id);
     List<DrinkInfoDto> getAll();
}
