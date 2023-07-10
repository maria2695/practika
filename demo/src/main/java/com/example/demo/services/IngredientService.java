package com.example.demo.services;



import com.example.demo.entities.Ingredient;

import java.util.List;

public interface IngredientService {
     Ingredient create(Ingredient ingredient);
     Ingredient read(Long id);
     Ingredient update(Ingredient ingredient, Long id);
     void delete(Long id);
     List<Ingredient> getAll();
}
