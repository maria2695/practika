package com.example.demo.services;

import com.example.demo.dto.ingredient.CreateIngredientDTO;
import com.example.demo.dto.ingredient.GetAllIngredientDTO;
import com.example.demo.dto.ingredient.ReadIngredientDTO;
import com.example.demo.dto.ingredient.UpdateIngredientDTO;

import java.util.List;

public interface IngredientService {
     CreateIngredientDTO create(CreateIngredientDTO ingredient);
     ReadIngredientDTO read(Long id);
     UpdateIngredientDTO update(UpdateIngredientDTO ingredient, Long id);
     void delete(Long id);
     List<GetAllIngredientDTO> getAll();
}
