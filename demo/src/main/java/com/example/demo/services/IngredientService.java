package com.example.demo.services;

import com.example.demo.dto.ingredient.IngredientInfoDto;
import com.example.demo.entities.Ingredient;

import java.util.List;

public interface IngredientService {
     IngredientInfoDto create(Ingredient ingredient, IngredientInfoDto ingredientInfoDto);
     IngredientInfoDto read(Long id);
     IngredientInfoDto update(IngredientInfoDto ingredient, Long id);
     void delete(Long id);
     List<IngredientInfoDto> getAll();
}

