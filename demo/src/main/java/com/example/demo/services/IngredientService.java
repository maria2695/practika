package com.example.demo.services;

import com.example.demo.dto.ingredient.IngredientInfoDto;

import java.util.List;

public interface IngredientService {
     IngredientInfoDto create(IngredientInfoDto ingredient);
     IngredientInfoDto read(Long id);
     IngredientInfoDto update(IngredientInfoDto ingredient, Long id);
     void delete(Long id);
     List<IngredientInfoDto> getAll();
}
