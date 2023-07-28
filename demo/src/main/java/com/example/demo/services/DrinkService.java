package com.example.demo.services;

import com.example.demo.dto.drink.DrinkInfoDto;

import java.util.List;

public interface DrinkService {
     DrinkInfoDto create(DrinkInfoDto createDrinkDTO);
     DrinkInfoDto read(Long id);
     DrinkInfoDto update(DrinkInfoDto updateDrinkDTO, Long id);
     void delete(Long id);
     List<DrinkInfoDto> getAll();
}
