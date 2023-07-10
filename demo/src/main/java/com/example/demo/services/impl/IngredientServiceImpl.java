package com.example.demo.services.impl;

import com.example.demo.entities.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient read(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient update(Ingredient ingredient, Long id) {
        Ingredient excitedIngredient = ingredientRepository.findById(id).orElse(null);
        if(excitedIngredient != null){
            excitedIngredient.setName(ingredient.getName());
            excitedIngredient.setNumberOfSales(ingredient.getNumberOfSales());
            excitedIngredient.setAcquisitionCost(ingredient.getAcquisitionCost());
            excitedIngredient.setRetailPrice(ingredient.getRetailPrice());
            excitedIngredient.setCount(ingredient.getCount());
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Long id) {
        ingredientRepository.deleteById(id);

    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
