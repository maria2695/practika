package com.example.demo.services.impl;

import com.example.demo.entities.Ingredient;
import com.example.demo.exception.NullEntityReferenceException;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.services.IngredientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public  IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public Ingredient create(Ingredient ingredient) {
        if(ingredient != null){
            return ingredientRepository.save(ingredient);
        }
        throw new NullEntityReferenceException("Ingredient cannot be 'null'");
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Ingredient with id"  + id +  "not found")
        );
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        if(ingredient != null){
            getIngredientById(ingredient.getId());
            return ingredientRepository.save(ingredient);
        }
        throw new NullEntityReferenceException("Ingredient cannot be 'null'");
    }

    @Override
    public void delete(Long id) {
        Ingredient ingredient = getIngredientById(id);
        ingredientRepository.delete(ingredient);

    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}

